package com.crm.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}123").roles("ADMIN")
                .and()
                .withUser("manager").password("{noop}123").roles("MANAGER")
                .and()
                .withUser("operator").password("{noop}123").roles("OPERATOR");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/**/company/**/").hasAnyRole("MANAGER", "SUPERUSER")
                .antMatchers(HttpMethod.PUT,"/**/company/**/").hasAnyRole("MANAGER", "SUPERUSER")
                .antMatchers(HttpMethod.POST,"/**/company/**/").hasAnyRole("OPERATOR", "SUPERUSER")
                .antMatchers(HttpMethod.POST,"/**/companys/**/").hasAnyRole("OPERATOR", "SUPERUSER")
                .antMatchers(HttpMethod.GET,"/**/companys/**/").hasAnyRole("OPERATOR", "MANAGER", "SUPERUSER")
                .antMatchers(HttpMethod.DELETE,"/**/client/**/").hasAnyRole("MANAGER", "SUPERUSER")
                .antMatchers(HttpMethod.PUT,"/**/client/**/").hasAnyRole("MANAGER", "SUPERUSER")
                .antMatchers(HttpMethod.POST,"/**/client/**/").hasAnyRole("OPERATOR", "SUPERUSER")
                .antMatchers(HttpMethod.POST,"/**/clients/**/").hasAnyRole("OPERATOR", "SUPERUSER")
                .antMatchers(HttpMethod.GET,"/**/clients/**/").hasAnyRole("OPERATOR", "MANAGER", "SUPERUSER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .disable()
                .httpBasic()
                .and()
                .csrf()
                .disable();
    }

}

