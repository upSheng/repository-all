package com.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SelfUserDetailsService selfUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //指定登录页的路径
                .loginPage("/login.html")
                //指定自定义form表单请求的路径
                .loginProcessingUrl("/loginController")
                .failureUrl("/login.html?error")
                .defaultSuccessUrl("/success")
                //必须允许所有用户访问我们的登录页（例如未验证的用户，否则验证流程就会进入死循环）
                //这个formLogin().permitAll()方法允许所有用户基于表单登录访问/login这个page。
                .permitAll();
        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
        http .csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 加入自定义的安全认证
        auth.userDetailsService(selfUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}