package ru.itis.restapidemo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import ru.itis.restapidemo.security.filters.TokenAuthenticationFilter;
import ru.itis.restapidemo.security.providers.TokenAuthenticationProvider;

// конфигурация безопасности, отменяет стандартную конфигурацию Spring Security
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan("ru.itis.restapidemo")
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenAuthenticationProvider tokenAuthenticationProvider;

    // описание самой конфигурации
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // authorizeRequests - все запросы, которые описаны ниже
        // должны пройти через механизм авторизации
        http.addFilterBefore(new TokenAuthenticationFilter(), BasicAuthenticationFilter.class);

//        http.authorizeRequests()
//                .antMatchers("/communities").hasAnyAuthority("ADMIN")
//                .antMatchers("/users").hasAnyAuthority("ADMIN")
//                .antMatchers("/users/**").hasAnyAuthority("ADMIN", "USER")
//                .antMatchers("/login").permitAll();

        http.formLogin()
                .disable();

        http
                .csrf()
                .disable();
        http.
                sessionManagement()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(tokenAuthenticationProvider);
    }
}
