package com.wang.waterbnb.project.services;

import com.wang.waterbnb.project.models.Role;
import com.wang.waterbnb.project.models.User;
import com.wang.waterbnb.project.repositories.RoleRepository;
import com.wang.waterbnb.project.repositories.UserRepository;
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
        String userName = user.getFirstName() + " " + user.getLastName();
        user.setUsername(userName);
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findHosts() {
        Role host = roleRepository.findRoleById(Long.valueOf(2));
        return host.getUsers();
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public Role findHostRole() {
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
}
