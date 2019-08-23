package com.login.auth.models.Data;

import com.login.auth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<User, String> {
    @Query("select u from Users where upper(u.username)= upper(username)")
    Boolean existsByIdIgnoreCase(String username);
}
