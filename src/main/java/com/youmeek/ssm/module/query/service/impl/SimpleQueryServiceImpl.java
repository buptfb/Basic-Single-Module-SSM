package com.youmeek.ssm.module.query.service.impl;

import com.youmeek.ssm.module.query.service.*;
import com.youmeek.ssm.module.rpc.ThriftClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by fanbo on 2017/4/11.
 */

@Service
public class SimpleQueryServiceImpl implements QueryService {
    @Override
    public String queryEs(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-client.xml");
        ThriftClient thriftClient = context.getBean(ThriftClient.class);
        thriftClient.invoke();
        return null;
    }
}
