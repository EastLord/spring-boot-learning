package com.dongjun.security.demo.service;

import com.dongjun.security.demo.entity.SysRole;
import com.dongjun.security.demo.entity.SysUser;
import com.dongjun.security.demo.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dongjun
 */
@Service
public class CustomUserServiceImpl implements UserDetailsService{

    @Autowired
    private SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        SysUser user = userRepository.findByUsername(username);

        if (user==null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用户添加用户权限，把用户权限添加到authorities中
        for (SysRole role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            System.out.println(role.getName());
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
