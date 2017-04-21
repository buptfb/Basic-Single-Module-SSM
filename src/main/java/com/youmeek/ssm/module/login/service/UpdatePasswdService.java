package com.youmeek.ssm.module.login.service;

import com.youmeek.ssm.module.login.pojo.UserInfo;

/**
 * Created by fanbo on 2017/4/20.
 */
public interface UpdatePasswdService {
    UserInfo setPasswd(String userName, String password);
}
