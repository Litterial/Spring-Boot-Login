package com.login.auth.models.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.login.auth.models.Role;

public interface RoleDAO extends JpaRepository<Role,String>{
}
