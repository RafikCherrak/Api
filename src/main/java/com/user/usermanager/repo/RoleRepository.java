package com.user.usermanager.repo;

import com.user.usermanager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findbyname(String name);
}
