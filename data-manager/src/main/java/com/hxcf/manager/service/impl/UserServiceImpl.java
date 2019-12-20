package com.hxcf.manager.service.impl;

import com.hxcf.manager.bean.UserBean;
import com.hxcf.manager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceImpl implements UserService {

    public UserBean loadUserByUsername(String s) {
        UserBean ub = new UserBean();
        ub.setUsername(s);
        ub.setPassword("123456");
        return ub;
    }

    public UserBean loadAuthByUser(UserBean userBean) {
        if (userBean == null)
            return null;
        String username = userBean.getUsername();
        //TODO - auth

        return userBean;
    }
}
