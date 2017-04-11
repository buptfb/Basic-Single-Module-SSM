package com.youmeek.ssm.module.doc.service;

import com.youmeek.ssm.module.doc.pojo.DocumentInfo;

import java.util.List;

/**
 * Created by fanbo on 2017/4/11.
 */
public interface DocService {
    List<DocumentInfo> getByJobID(Integer jobID);
}
