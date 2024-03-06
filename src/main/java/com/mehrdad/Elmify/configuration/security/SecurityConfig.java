package com.mehrdad.Elmify.configuration.security;

import com.mehrdad.Elmify.service.StudentService;
import com.mehrdad.Elmify.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// SecurityConfig.java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/signup").permitAll() // Allow public access to home and signup pages
                .anyRequest().authenticated() // All other endpoints require authentication
                .and()
                .formLogin()
                .loginPage("/login") // Custom login page
                .permitAll() // Allow public access to login page
                .and()
                .logout()
                .permitAll(); // Allow public access to logout
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, StudentService studentService, TeacherService teacherService) throws Exception {
        auth.userDetailsService(userDetailsService(studentService, teacherService)).passwordEncoder(passwordEncoder());
    }

    @Bean
    public UserDetailsService userDetailsService(StudentService studentService, TeacherService teacherService) {
        return new UserDetailsServiceImpl(studentService, teacherService);
    }
}

