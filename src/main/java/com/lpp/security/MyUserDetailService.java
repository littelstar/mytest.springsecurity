package com.lpp.security;

import com.lpp.domain.Permission;
import com.lpp.domain.User;
import com.lpp.mapper.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class MyUserDetailService  implements UserDetailsService{

    private Logger logger=Logger.getLogger(MyUserDetailService.class);

    @Resource
    private UserMapper userMapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("测试");
//        获取用户
        User user = userMapper.findUserByName(username);
        if(user!=null){

//        获取权限信息
            List<Permission> permissions= userMapper.findPermissionByName(username);
            ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

            for(Permission permission:permissions){
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(permission.getPermissionTag());
                grantedAuthorities.add(simpleGrantedAuthority);
            }
            user.setAuthorities(grantedAuthorities);
            logger.info(user);
        }

        return user;
    }
}
