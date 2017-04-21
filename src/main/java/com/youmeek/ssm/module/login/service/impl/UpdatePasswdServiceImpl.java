package com.youmeek.ssm.module.login.service.impl;

import com.youmeek.ssm.module.login.mapper.UserInfoMapper;
import com.youmeek.ssm.module.login.pojo.UserInfo;
import com.youmeek.ssm.module.login.service.UpdatePasswdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by fanbo on 2017/4/20.
 */
@Service
public class UpdatePasswdServiceImpl implements UpdatePasswdService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo setPasswd(String userName, String password){
        if(null == userName || null == password){
            return null;
        }
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userName);
        if(null == userInfo){
            return null;
        }
        System.out.println(userInfo.getUserEmail());
        userInfo.setUserPwd(password);
        //更新到库
        userInfoMapper.updateByPrimaryKey(userInfo);
        return userInfo;
    }

}
