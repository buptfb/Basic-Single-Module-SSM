package com.youmeek.ssm.module.query.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.youmeek.ssm.module.query.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by fanbo on 2017/4/11.
 */

@Service
public class SimpleQueryServiceImpl implements QueryService {

    @Override
    public String queryEs() {
        Client2 client = new Client2();

        JSONArray jsonArray = Client2.readTxtFile("C:\\Thrift\\java\\json.txt");
        System.out.println(jsonArray.toJSONString());

        client.startClient(ConfirmAction.UPDATE, 1, jsonArray.toJSONString());
        //client.startClient(Action.QUERY,10,"{\"query\":{\"bool\":{\"must\":[{\"match_all\":{}}],\"must_not\":[],\"should\":[]}},\"from\":0,\"size\":10,\"sort\":[],\"aggs\":{}}");
        return null;
    }
}
