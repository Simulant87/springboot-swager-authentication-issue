package com.example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

//@Configuration
//@EnableWebSecurity
//class SecurityConfigurer {
//
//    @Bean
//    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
//        http
//            .csrf().disable()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and().authorizeHttpRequests().requestMatchers(
//                // Open API Docs & UI
//                "/swagger-ui.html",
//                "/swagger-ui/**",
//                "/v3/api-docs/**",
//                // Health & live and readiness probes
//                "/actuator/health",
//            ).permitAll()
//            .and().authorizeHttpRequests().anyRequest().authenticated()
//
//        return http.build()
//    }
//}

// configuration for Spring Boot 2.7.8
@Configuration
@EnableWebSecurity
class SecurityConfigurer : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().authorizeRequests()
            .anyRequest().authenticated()
    }

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
            // Open API Docs & UI
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            // Health & live and readiness probes
            "/actuator/health",
        )
    }
}
