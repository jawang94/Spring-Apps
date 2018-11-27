package com.wang.dojooverflow.project.services;

import com.wang.dojooverflow.project.models.Question;
import com.wang.dojooverflow.project.models.Tag;
import com.wang.dojooverflow.project.repositories.QuestionRepository;
import com.wang.dojooverflow.project.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class TagService {
    @Autowired
    private final TagRepository tagRepository;
    private final QuestionRepository questionRepository;
    private QuestionService questionService;

    public TagService (TagRepository tagRepository, QuestionRepository questionRepository) {
        this.tagRepository = tagRepository;
        this.questionRepository = questionRepository;
    }

    public List<Tag> findAll() {
        List<Tag> tagList = tagRepository.findAll();
        return  tagList;
    }


    public List<Tag> createTag(List<String> tags) {
        ArrayList<Tag> tagList = new ArrayList<Tag>();
        for (String tag: tags) {
            Tag newTag = newTag(tag);
            tagList.add(newTag);
            tagRepository.save(newTag);
        }
        return tagList;
    }

    public Tag newTag(String string) {
        Tag tag = new Tag(string);
        return tag;
    }

    public Tag findTag(Long id) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if(optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    }

    public List<Tag> addQuestion(Question q, List<Tag> t) {
        for (Tag tag: t) {
            List<Question> qList = tag.getQuestions();
            qList.add(q);
            tag.setQuestions(qList);
            tagRepository.save(tag);
        }
        return tagRepository.findAll();
    }

    public List<Tag> findTagByQuestion(Question question) {
        List<Tag> tagList = tagRepository.findAllByQuestionsOrderByCreatedAt(question);
        return tagList;
    }
}
