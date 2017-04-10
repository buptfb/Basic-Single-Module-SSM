package com.youmeek.ssm.module.esindex.service;

/**
 * Created by fanbo on 2017/4/5.
 */
import com.youmeek.ssm.module.esindex.pojo.EsIndex;

import javax.json.JsonObject;
import java.util.List;

public interface EsIndexService {
    EsIndex getById(Integer id);

    List<EsIndex> getALL();
}
