package com.spring.db.springbootmysql.repository;

import com.spring.db.springbootmysql.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>,UsersRepositoryCustom {
}
