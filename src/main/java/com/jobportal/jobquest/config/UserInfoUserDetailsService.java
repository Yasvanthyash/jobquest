package com.jobportal.jobquest.config;
// package com.admission.eduadmit_connect.Config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jobportal.jobquest.Model.*;
import com.jobportal.jobquest.Repository.*;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String usermail) throws UsernameNotFoundException {
        Optional<UserModel> loginInfo = repository.findByEmail(usermail);
        return loginInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + usermail));

    }
}