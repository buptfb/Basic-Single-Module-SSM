package com.youmeek.ssm.module.job.service;

import com.youmeek.ssm.module.job.pojo.JobInfo;

import java.util.List;

/**
 * Created by fanbo on 2017/4/11.
 */
public interface JobService {
    List<JobInfo> getByUserName(String userName);
}
