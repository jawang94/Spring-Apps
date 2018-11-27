package com.wang.dojooverflow.project.repositories;

import com.wang.dojooverflow.project.models.Question;
import com.wang.dojooverflow.project.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    public List<Tag> findAll();
    public List<Tag> findAllByQuestionsOrderByCreatedAt(Question question);
}

