package com.wang.dojooverflow.project.repositories;

import com.wang.dojooverflow.project.models.Question;
import com.wang.dojooverflow.project.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    public List<Question> findAll();
    public List<Question> findAllByTagsOrderByCreatedAt(Tag tag);
}
