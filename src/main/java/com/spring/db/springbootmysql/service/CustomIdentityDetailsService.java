package com.spring.db.springbootmysql.service;

import com.spring.db.springbootmysql.model.CustomIdentityDetails;
import com.spring.db.springbootmysql.model.Identity;
import com.spring.db.springbootmysql.repository.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomIdentityDetailsService implements UserDetailsService {

    @Autowired
    IdentityRepository identityRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Identity> optionalIdentity = identityRepository.findByUserName(username);

        final CustomIdentityDetails customIdentityDetails = optionalIdentity
                                                                    .map(identity -> new CustomIdentityDetails(identity))
                                                                    .get();

        optionalIdentity.orElseThrow(() -> new UsernameNotFoundException("No such user exists"));

        return customIdentityDetails;
    }
}
