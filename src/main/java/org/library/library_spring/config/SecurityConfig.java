package org.library.library_spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) //Отключаем защиту CSRF для упрощения тестов в Postman
                .authorizeHttpRequests(auth -> auth
                        //Просматривать (GET) можно всем без пароля
                        .requestMatchers(HttpMethod.GET, "/authors/**", "/books/**").permitAll()
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()

                        //Создавать и удалять может только ADMIN
                        .requestMatchers(HttpMethod.POST, "/authors/**", "/books/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/authors/**", "/books/**").hasRole("ADMIN")

                        //Все остальные запросы требуют логина
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); //базовуя аутентификация

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //DefaultPasswordEncoder для тестов
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}