package com.spring.db.springbootmysql.repository;

import com.spring.db.springbootmysql.model.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdentityRepository extends JpaRepository<Identity, Integer> {

    Optional<Identity> findByUserName(String username);
}
