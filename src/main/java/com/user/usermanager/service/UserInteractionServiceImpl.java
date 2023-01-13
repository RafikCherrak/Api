package com.user.usermanager.service;

import com.user.usermanager.model.Role;
import com.user.usermanager.model.User;
import com.user.usermanager.repo.RoleRepository;
import com.user.usermanager.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class UserInteractionServiceImpl implements UserInteractionService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("Sauvegarde d'un nouveau utilisateur dans la base de donnée");
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Sauvegarde d'un nouveau role dans la base de données ");
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findbyUsername(username);
        Role role = roleRepository.findbyname(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findbyUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
