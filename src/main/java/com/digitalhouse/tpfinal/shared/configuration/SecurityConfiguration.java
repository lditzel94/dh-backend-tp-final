package com.digitalhouse.tpfinal.shared.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder BCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
        http.authorizeHttpRequests()
            .requestMatchers( "/api/" ).hasAnyRole( "USER", "ADMIN" )
            .requestMatchers( "/swagger-ui.html" ).hasRole( "ADMIN" )
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic();
        http.csrf().disable();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService( BCryptPasswordEncoder bCryptPasswordEncoder ) {
        var manager = new InMemoryUserDetailsManager();
        manager.createUser( User.withUsername( "user" )
                                .password( bCryptPasswordEncoder.encode( "password" ) )
                                .roles( "USER" )
                                .build() );
        manager.createUser( User.withUsername( "admin" )
                                .password( bCryptPasswordEncoder.encode( "password" ) )
                                .roles( "USER", "ADMIN" )
                                .build() );
        return manager;
    }
}
