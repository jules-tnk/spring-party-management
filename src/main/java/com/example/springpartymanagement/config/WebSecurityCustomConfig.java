package com.example.springpartymanagement.config;

import com.example.springpartymanagement.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityCustomConfig {
    private final CustomUserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    public WebSecurityCustomConfig(CustomUserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }


    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder.encode("password"))
                .authorities("USER")
                .roles("USER")
                .and()
                .withUser("admin").
                password(passwordEncoder.encode("admin")).
                roles("ADMIN").authorities("ADMIN");

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
