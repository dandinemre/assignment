package com.crediteuropebank.assignment.configuration;

import com.crediteuropebank.assignment.model.Users;
import com.crediteuropebank.assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        userRepository.save(new Users(1L,"dandin","$2a$12$FDquvTXSd6nz7bzkDogo5.fl7HoREPVj1VAmr8PfMFSNmPl8DJDGS",1));
    }
}
