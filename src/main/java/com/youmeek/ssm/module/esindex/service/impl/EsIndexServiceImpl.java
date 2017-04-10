package com.youmeek.ssm.module.esindex.service.impl;

import com.youmeek.ssm.module.esindex.mapper.EsIndexMapper;
import com.youmeek.ssm.module.esindex.pojo.EsIndex;
import com.youmeek.ssm.module.esindex.service.EsIndexService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.json.JsonObject;
import javax.validation.OverridesAttribute;
import java.util.List;


/**
 * Created by fanbo on 2017/4/5.
 */
@Service
public class EsIndexServiceImpl implements EsIndexService {

    @Resource
    private EsIndexMapper esIndexMapper;


    @Override
    public EsIndex getById(Integer indexId) {
        return esIndexMapper.selectByPrimaryKey(indexId);
    }

    @Override
    public List<EsIndex> getALL() {
        return esIndexMapper.selectAll();
    }
}
