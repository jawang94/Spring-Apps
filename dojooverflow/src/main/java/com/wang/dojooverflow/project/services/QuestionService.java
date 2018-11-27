package com.wang.dojooverflow.project.services;

import com.wang.dojooverflow.project.models.Question;
import com.wang.dojooverflow.project.models.Tag;
import com.wang.dojooverflow.project.repositories.QuestionRepository;
import com.wang.dojooverflow.project.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {
    @Autowired
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;

    public QuestionService (QuestionRepository questionRepository, TagRepository tagRepository) {
        this.questionRepository = questionRepository;
        this.tagRepository = tagRepository;
    }

    public List<Question> findAll() {
        List<Question> questionList = questionRepository.findAll();
        return  questionList;
    }


    public Question createQuestion(Question q) {
        return questionRepository.save(q);
    }

    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }

    public Question addTags(Question newQuestion, Question oldQuestion) {
        Question questionToUpdate = findQuestion(oldQuestion.getId());
        List<Tag> newList = newQuestion.getTags();
        List<Tag> oldList = oldQuestion.getTags();
        oldList.addAll(newList);
        questionToUpdate .setTags(oldList);
        return questionRepository.save(questionToUpdate);
    }

    public List<Question> findQuestionByTag(Tag tag) {
        List<Question> questionList = questionRepository.findAllByTagsOrderByCreatedAt(tag);
        return questionList;
    }
}
