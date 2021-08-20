package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.demo.security.ApplicationUserPermission.*;
import static com.example.demo.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index").permitAll()
                .antMatchers("/myaccount/**").hasAnyRole(ADMIN.name(), MANAGER.name())
                .antMatchers(HttpMethod.POST, "/cars-catalog/**").hasAuthority(ADMIN_REPORT_CLIENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
//       Added a new admin
        UserDetails billyHerringtonBuilder = User.builder()
                .username("Billy Herrington")
                .password(passwordEncoder.encode("NUMBERONE"))
                .roles(ADMIN.name())
                .authorities(ADMIN_REPORT_CLIENT.name())
                .build();
//      Added a new client
        UserDetails clientBuilder = User.builder()
                .username("Edward Elric")
                .password(passwordEncoder.encode("12345"))
                .roles(CLIENT.name())
                .build();
//        Added manager
        UserDetails managerBuilder = User.builder()
                .username("Anilop")
                .password(passwordEncoder.encode("password"))
                .roles(MANAGER.name())
                .build();
        return new  InMemoryUserDetailsManager(billyHerringtonBuilder, clientBuilder, managerBuilder);
    }
}
