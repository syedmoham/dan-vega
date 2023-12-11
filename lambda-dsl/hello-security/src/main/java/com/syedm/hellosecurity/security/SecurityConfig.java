package com.syedm.hellosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


/*
  // orignal method requiring chaining using and()
  @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                *//*
                    1. order of request matchers is important
                    2. every request has to be authenticated
                    3. use basic authentication
                 *//*
        http.authorizeHttpRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("/api/posts").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .httpBasic()
        return http.build();

    }*/

    /* Lambda DSL
    In the Lambda DSL there is no need to chain configuration options using the .and() method
    The HttpSecurity instance is automatically returned for further  configuration after the call
    https://spring.io/blog/2019/11/21/spring-security-lambda-dsl
     */

    @Bean
    public SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
        /*
            1. Customizer is a functional interface so we can use a lambda expression

         */
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/api/posts/**").hasRole("ADMIN");
                    auth.anyRequest().authenticated();
                })
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
