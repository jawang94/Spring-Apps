package com.wang.auth.project.repositories;

import com.wang.auth.project.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    User findByUsername(String username);
    User findByEmail(String email);
    @Query(value = "SELECT count(users.id) as admins FROM users JOIN users_roles ON users.id = users_roles.user_id WHERE users_roles.role_id = 2", nativeQuery = true)
    Integer findNumberOfAdmins();
}
