package com.dongjun.security.demo.repository;

import com.dongjun.security.demo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dongjun
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long>{

    /**
     * 通过username查找SysUser实体
     * @param username
     * @return SysUser
     */
     SysUser findByUsername(String username);

}
