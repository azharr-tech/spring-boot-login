package com.spring.db.springbootmysql.resource;

import com.spring.db.springbootmysql.model.Users;
import com.spring.db.springbootmysql.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UserResource {

    @Autowired
    UsersRepository usersRepository;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "all",produces = "application/json")
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody final Users user){
        usersRepository.saveAndFlush(user);
    }
    @GetMapping("/salary/{sal}")
    public List<Users> getUserWithSalaryFilter(@PathVariable Double sal){
        return usersRepository.getAllUsersWithSalaryGreaterThanX(sal);
    }

}
