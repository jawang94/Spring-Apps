package com.wang.eventsbeltreviewer.project.repositories;

import com.wang.eventsbeltreviewer.project.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

    @Query(value = "SELECT count(users.id) FROM users JOIN events_users ON events_users.user_id = users.id JOIN events ON events_users.event_id = events.id WHERE events.id = ?1", nativeQuery = true)
    Integer findNumberOfAttendees(Long id);
}

