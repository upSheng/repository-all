package com.web.config;

import com.web.entity.User;
import com.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SelfUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService iUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //构建用户信息的逻辑(取数据库/LDAP等用户信息)

        User user = iUserService.findByName(username);

        if (user == null){
            throw  new UsernameNotFoundException(username);
        }
        SelfUserDetails userInfo = new SelfUserDetails();
        userInfo.setUsername(username);
        //userInfo.setPassword(new BCryptPasswordEncoder().encode("123"));
        userInfo.setPassword(user.getPassword());

        Set authoritiesSet = new HashSet();
        GrantedAuthority authority1 = new SimpleGrantedAuthority("admin");

        GrantedAuthority authority2 = new SimpleGrantedAuthority("chs");
        authoritiesSet.add(authority1);
        authoritiesSet.add(authority2);
        userInfo.setAuthorities(authoritiesSet);

        return userInfo;
    }
}
