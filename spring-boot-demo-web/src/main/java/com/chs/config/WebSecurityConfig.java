package com.chs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/8/5<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/8/5            创建
 * --------------------------------------------------------------------
 * </pre>
 */
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

//    @Bean
//    public UserDetailsService userDetailsService() throws Exception {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
//        manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("password").roles("ADMIN").build());
//        return manager;
//    }


    UserDetailsService userDetailsService;

    @Bean
    public UserDetailsService userDetailsService() throws Exception {

//        SelfUserDetails userInfo = new SelfUserDetails();
//        userInfo.setUsername("zhangsan");
//        userInfo.setPassword(new BCryptPasswordEncoder().encode("123"));
//
//        Set authoritiesSet = new HashSet();
//        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
//        authoritiesSet.add(authority);
//        userInfo.setAuthorities(authoritiesSet);


        return userDetailsService;
    }
}
