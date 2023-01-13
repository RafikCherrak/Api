package com.user.usermanager.repo;

import com.user.usermanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    void deleteUserById(Long id);

    User findbyUsername(String username);

    Optional<User> findUserById(Long id);
}
