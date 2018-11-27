package com.wang.dojooverflow.project.services;

import com.wang.dojooverflow.project.models.Answer;
import com.wang.dojooverflow.project.models.Question;
import com.wang.dojooverflow.project.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    private final AnswerRepository answerRepository;


    public AnswerService (AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    public Answer createAnswer(Answer a) {
        return answerRepository.save(a);
    }

    public Answer addQuestion(Answer a, Question q) {
        a.setQuestion(q);
        return answerRepository.save(a);
    }

    public Answer findAnswer(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if(optionalAnswer.isPresent()) {
            return optionalAnswer.get();
        } else {
            return null;
        }
    }

    public List<Answer> findByQuestion(Question q) {
        return answerRepository.findAllByQuestionOrderByCreatedAt(q);
    }

}
