package com.salavatcioglu.apiresource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        //ttp.authorizeHttpRequests().requestMatchers("/**").hasRole("USER").and().formLogin();
        http
            .authorizeHttpRequests(auth ->
                auth.requestMatchers("/**").hasAuthority("SCOPE_message.read")
            )
            .oauth2ResourceServer(oAuth2 ->
                oAuth2.jwt(Customizer.withDefaults())
            );

        return http.build();
    }

}
