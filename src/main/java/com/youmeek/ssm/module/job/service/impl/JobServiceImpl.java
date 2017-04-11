package com.youmeek.ssm.module.job.service.impl;

import com.youmeek.ssm.module.job.mapper.JobInfoMapper;
import com.youmeek.ssm.module.job.pojo.JobInfo;
import com.youmeek.ssm.module.job.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fanbo on 2017/4/11.
 */
@Service
public class JobServiceImpl implements JobService{

    @Resource
    private JobInfoMapper jobInfoMapper;


    @Override
    public List<JobInfo> getByUserName(String userName) {

        return jobInfoMapper.selectByUserName(userName);
    }

}
