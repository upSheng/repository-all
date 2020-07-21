package com.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;


/**
 * @author Administrator
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 未登陆时返回 JSON 格式的数据给前端（否则为 html）
     */
    @Resource
    AjaxAuthenticationEntryPoint authenticationEntryPoint;

    /**
     * 登录成功返回的 JSON 格式数据给前端（否则为 html）
     */
    @Resource
    AjaxAuthenticationSuccessHandler authenticationSuccessHandler;

    /**
     * 登录失败返回的 JSON 格式数据给前端（否则为 html）
     */
    @Resource
    AjaxAuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 注销成功返回的 JSON 格式数据给前端（否则为 登录时的 html）
     */
    @Resource
    AjaxLogoutSuccessHandler logoutSuccessHandler;

    /**
     * JWT 拦截器
     */
    @Resource
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    SelfUserDetailsService selfUserDetailsService;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/index.html").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                //指定登录页的路径
//                .loginPage("/login.html")
//                //指定自定义form表单请求的路径
//                .loginProcessingUrl("/loginController")
//                .failureUrl("/login.html?error")
//                .defaultSuccessUrl("/success")
//                //必须允许所有用户访问我们的登录页（例如未验证的用户，否则验证流程就会进入死循环）
//                //这个formLogin().permitAll()方法允许所有用户基于表单登录访问/login这个page。
//                .permitAll();
//        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
//        http .csrf().disable();
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 去掉 CSRF
        http.csrf().disable()
                // 使用 JWT，关闭token
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .httpBasic().authenticationEntryPoint(authenticationEntryPoint)

                .and()
                .authorizeRequests()
                .antMatchers("/druid/**", "/ignore/**").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin()  //开启登录
                // 登录成功
                .successHandler(authenticationSuccessHandler)
                // 登录失败
                .failureHandler(authenticationFailureHandler)
                .permitAll()

                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll();


        // JWT Filter
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 加入自定义的安全认证

        auth.userDetailsService(selfUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * 忽视静态文件
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger-ui.html")
                .antMatchers("/webjars/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/static/**")
                .antMatchers("/v2/**");

    }

}