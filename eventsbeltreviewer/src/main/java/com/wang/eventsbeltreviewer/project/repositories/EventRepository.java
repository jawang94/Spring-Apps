package com.wang.eventsbeltreviewer.project.repositories;

import com.wang.eventsbeltreviewer.project.models.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAllByStateOrderByCreatedAtDesc(String state);

    List<Event> findAllByStateIsNotContainingOrderByCreatedAtDesc(String state);

}

