package com.youmeek.ssm.module.doc.service.impl;

import com.youmeek.ssm.module.doc.mapper.DocumentInfoMapper;
import com.youmeek.ssm.module.doc.pojo.DocumentInfo;
import com.youmeek.ssm.module.doc.service.DocService;
import org.springframework.jdbc.support.DatabaseMetaDataCallback;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fanbo on 2017/4/11.
 */
@Service
public class DocServiceImpl implements DocService{
    @Resource
    private DocumentInfoMapper documentInfoMapper;

    @Override
    public List<DocumentInfo> getByJobID(Integer jobID) {
        return documentInfoMapper.selectByJobID(jobID);
    }



}
