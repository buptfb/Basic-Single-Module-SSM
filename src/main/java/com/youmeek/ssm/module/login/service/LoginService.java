package com.youmeek.ssm.module.login.service;

import com.youmeek.ssm.module.login.pojo.UserInfo;
import com.youmeek.ssm.module.login.pojo.UserInfo;

/**
 * Created by fanbo on 2017/4/8.
 */
public interface LoginService {
    UserInfo checkAccount(String userName, String password);
}
