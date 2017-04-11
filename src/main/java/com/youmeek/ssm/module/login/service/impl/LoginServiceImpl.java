package com.youmeek.ssm.module.login.service.impl;

import com.youmeek.ssm.module.login.mapper.UserInfoMapper;
import com.youmeek.ssm.module.login.pojo.UserInfo;

import com.youmeek.ssm.module.login.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by fanbo on 2017/4/8.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo checkAccount(String userName, String password) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userName);
        System.out.println(userInfo.getUserEmail());
        if (password.equals(userInfo.getUserPwd())) return userInfo;
        return null;
    }
}
