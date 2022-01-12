package com.crediteuropebank.assignment.service;

import com.crediteuropebank.assignment.model.Users;
import com.crediteuropebank.assignment.repository.UserRepository;
import com.crediteuropebank.assignment.service.impl.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService  {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User Not Found");

        return new CustomUserDetails(user);
    }
}
