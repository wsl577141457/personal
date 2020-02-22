package com.longge.config;

import com.longge.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ILoginService loginService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login.html","/login","/static/**","/templates/error/**").permitAll()
                .antMatchers("/adminPage/**").hasRole("管理员")
                .antMatchers("/teacherPage/**").hasRole("老师")
                .antMatchers("/studentPage/**").hasRole("学生")
                .anyRequest().authenticated();
        http.formLogin().loginPage("/login");
        http.csrf().disable();
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginService).passwordEncoder(new BCryptPasswordEncoder());
       /* auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("longge").password(new BCryptPasswordEncoder().encode("123")).roles("学生");*/
    }


}
