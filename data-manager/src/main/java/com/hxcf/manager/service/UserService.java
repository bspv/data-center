package com.hxcf.manager.service;

import com.hxcf.manager.bean.UserBean;

public interface UserService {
    UserBean loadUserByUsername(String s);

    UserBean loadAuthByUser(UserBean userBean);
}
