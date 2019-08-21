package com.login.auth.models.Data;

import com.login.auth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<User,Integer> {
}
