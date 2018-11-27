package com.wang.beltexam.project.services;

import com.wang.beltexam.project.models.Role;
import com.wang.beltexam.project.models.User;
import com.wang.beltexam.project.repositories.RoleRepository;
import com.wang.beltexam.project.repositories.UserRepository;
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

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        String userName = user.getName();
        user.setUsername(userName);
        List<Role> role = roleRepository.findByName("ROLE_USER");
        user.setRoles(role);
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Role findRole() {
        return roleRepository.findRoleById(Long.valueOf(1));
    }

    public User findById(Long id) {
        Optional<User> u = userRepository.findById(id);
        if(u.isPresent()) {
            return u.get();
        } else {
            return null;
        }
    }
}