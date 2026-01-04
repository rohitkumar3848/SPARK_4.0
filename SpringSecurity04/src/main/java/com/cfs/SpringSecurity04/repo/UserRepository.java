package com.cfs.SpringSecurity04.repo;

import com.cfs.SpringSecurity04.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser,String> {

    Optional<AppUser> findByUsername(String username);
}
