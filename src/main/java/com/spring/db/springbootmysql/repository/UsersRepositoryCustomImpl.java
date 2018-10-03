package com.spring.db.springbootmysql.repository;

import com.spring.db.springbootmysql.model.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UsersRepositoryCustomImpl implements UsersRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Users> getAllUsersWithSalaryGreaterThanX(Double sal) {
        String str = "select * from users where salary > ?";

        Query query = entityManager.createNativeQuery(str);
        query.setParameter(1,sal);

        return query.getResultList();
    }

    @Override
    public List<Users> getAllUsersWithDevTeam() {
        String str = "select * from users where team = ?";

        Query query = entityManager.createNativeQuery(str);
        query.setParameter(1,"dev");

        return query.getResultList();
    }


}
