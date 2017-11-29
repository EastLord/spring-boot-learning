package com.dongjun.security.demo.service;

import com.dongjun.security.demo.entity.SysUser;
import com.dongjun.security.demo.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dongjun
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private SysUserRepository userRepository;

    @Override
    public SysUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
