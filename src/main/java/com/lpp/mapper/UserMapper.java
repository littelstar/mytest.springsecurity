package com.lpp.mapper;

import com.lpp.domain.Permission;
import com.lpp.domain.User;

import java.util.List;

public interface UserMapper {
    User findUserByName(String username);
    List<Permission> findPermissionByName(String username);
    void updateUserPassword(User user);
}
