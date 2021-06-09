package com.revature.repos;


import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
