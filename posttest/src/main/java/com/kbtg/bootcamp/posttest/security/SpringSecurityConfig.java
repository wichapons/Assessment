package com.kbtg.bootcamp.posttest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import static org.springframework.security.config.Customizer.withDefaults;

@Component
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(requests -> requests.requestMatchers(HttpMethod.GET,"/lotteries").permitAll()
                .requestMatchers(HttpMethod.POST,"/users/*/lotteries/*").permitAll()
                .requestMatchers(HttpMethod.GET,"/users/*/lotteries").permitAll()
                .requestMatchers(HttpMethod.DELETE,"/users/*/lotteries/*").permitAll()
                .anyRequest().authenticated());
        //http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    //for encoding incoming request password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //for user authentication 
    @Bean
    public UserDetailsService userDetailsService() {
        BCryptPasswordEncoder encodedPassword = new BCryptPasswordEncoder();
        //for dev purpose only - not for production (we have to use database)
        UserDetails user = User.withUsername("admin").password(encodedPassword.encode("password")).build();
        return new InMemoryUserDetailsManager(user);
    }


}
