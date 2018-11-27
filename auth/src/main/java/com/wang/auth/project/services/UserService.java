package com.wang.auth.project.services;

import com.wang.auth.project.models.Role;
import com.wang.auth.project.models.User;
import com.wang.auth.project.repositories.RoleRepository;
import com.wang.auth.project.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        String userName = user.getFirstName() + " " + user.getLastName();
        user.setUsername(userName);
        userRepository.save(user);
    }

    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        String userName = user.getFirstName() + " " + user.getLastName();
        user.setUsername(userName);
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Integer findNumberOfAdmins() {
        return userRepository.findNumberOfAdmins();
    }

    public List<User> findAdmins() {
        Role admin = roleRepository.findRoleById(Long.valueOf(2));
        return admin.getUsers();
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Role findAdminRole() {
        return roleRepository.findRoleById(Long.valueOf(2));
    }

    public User findById(Long id) {
        Optional<User> u = userRepository.findById(id);
        if(u.isPresent()) {
            return u.get();
        } else {
            return null;
        }
    }

    public void makeAdmin(User user) {
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}