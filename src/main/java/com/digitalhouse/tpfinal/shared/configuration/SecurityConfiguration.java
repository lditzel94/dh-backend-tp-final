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

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder BCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
        return http
                .authorizeHttpRequests( auth -> auth
                        .requestMatchers( "/api/**" ).hasAnyRole( "ADMIN", "USER" )
                        .requestMatchers( "/swagger-ui.html" ).hasRole( "ADMIN" )
                        .requestMatchers( toH2Console() ).hasRole( "ADMIN" )
                        .anyRequest().authenticated()
                )
                .csrf().ignoringRequestMatchers( toH2Console() ).and()
                .headers( headers -> headers.frameOptions().disable() )
                .formLogin().and()
                .httpBasic().and()
                .build();
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
                                .roles( "ADMIN" )
                                .build() );
        return manager;
    }


}
