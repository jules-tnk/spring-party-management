package com.example.springpartymanagement.service;

import com.example.springpartymanagement.entity.AppUser;
import com.example.springpartymanagement.repository.AppUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final AppUserRepository appUserRepository;

    public CustomUserDetailsService(PasswordEncoder passwordEncoder,
                                    AppUserRepository appUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        return new User(username,
                appUser.getPassword(),
                Collections.singletonList(
                        new SimpleGrantedAuthority(appUser.getRoleName())
                )
        );

    }

    /*public boolean addUser(String username, String password) {
        boolean userExists = appUserRepository.existsByUsername(username);
        if (userExists) {
            throw new IllegalStateException("User already exists");
        }

        String encodedPassword = passwordEncoder.encode(password);
        appUserRepository.save(new AppUser(username, encodedPassword));
        return true;

    }*/

}
