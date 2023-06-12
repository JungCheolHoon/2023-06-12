package com.mz.b2b.webchatclone.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationFailureHandler customFailureHandler;

    @Autowired
    private MemberDetailServiceImpl memberDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberDetailService).passwordEncoder(passwordEncoder());
    }

    /* static 관련설정은 무시 */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests().antMatchers("/index", "/system/**", "/error/**").permitAll();
        security.authorizeHttpRequests().antMatchers("/", "/member/**").authenticated();
        security.authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN");

        security.csrf().disable();

        security.formLogin().loginPage("/system/login").defaultSuccessUrl("/index", true);

        security.exceptionHandling().accessDeniedPage("/system/accessDenied");

        security.logout().invalidateHttpSession(true).logoutSuccessUrl("/system/login");

        security.userDetailsService(memberDetailService);

        security.formLogin().failureHandler(customFailureHandler);
    }

}

