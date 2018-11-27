package com.wang.dojooverflow.project.repositories;

import com.wang.dojooverflow.project.models.Answer;
import com.wang.dojooverflow.project.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    public List<Answer> findAll();
    public List<Answer> findAllByQuestionOrderByCreatedAt(Question question);
}
