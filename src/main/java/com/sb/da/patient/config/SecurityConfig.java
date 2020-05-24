package com.sb.da.patient.config;

import com.sb.da.patient.service.FirebaseService;
import com.sb.da.patient.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().fullyAuthenticated()
                .and()
                .formLogin().and()
                .rememberMe()
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                .useSecureCookie(true)
                .key("remember-me")
                .rememberMeCookieName("remember-me")
                .and()
                .logout()
                .deleteCookies("remember-me");
        http.csrf().disable();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/patients/**")
//                .access("hasRole('USER')")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                //.loginPage("/login")
//                //.failureUrl("/login?error")
//                .permitAll()
//                .and()
//                .rememberMe()
//                .tokenValiditySeconds(60 * 60 * 24 * 7)
//                .useSecureCookie(true)
//                .key("remember-me")
//                .rememberMeCookieName("remember-me")
//                .and()
//                .logout()
//                .deleteCookies("remember-me")
//                .permitAll();
////
//    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}

