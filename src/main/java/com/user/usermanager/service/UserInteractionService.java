package com.user.usermanager.service;

import com.user.usermanager.model.Role;
import com.user.usermanager.model.User;

import java.util.List;

public interface UserInteractionService {
User saveUser(User user);
Role saveRole(Role role);
void addRoleToUser(String username, String roleName);
User getUser(String username);
List<User>getUsers();
}
