package com.spring.db.springbootmysql.repository;

import com.spring.db.springbootmysql.model.Users;
import java.util.List;

public interface UsersRepositoryCustom {

    List<Users> getAllUsersWithSalaryGreaterThanX(Double sal);
    List<Users> getAllUsersWithDevTeam();


}
