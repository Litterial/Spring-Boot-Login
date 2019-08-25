package com.login.auth.models.Data;

import com.login.auth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<User, String> {
    @Query("select username from User where upper(username)= upper(:username)")
    String existsByIdIgnoreCase(String username);
}
