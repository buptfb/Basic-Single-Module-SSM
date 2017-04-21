package com.youmeek.ssm.module.query.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.youmeek.ssm.module.query.service.QueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by fanbo on 2017/4/20.
 */

@Controller
@RequestMapping("/query")
public class QueryController {
    /**
     * Created by fanbo on 2017/4/8.
     */

       private static final Logger LOG = LoggerFactory.getLogger(QueryController.class);
        @Resource
        private QueryService queryService;

        @RequestMapping(method = RequestMethod.GET)
        public String query(HttpServletResponse response) {
            response.setHeader("Access-Control-Allow-Origin", "*");
            //解析参数
            JSONObject jsonObject = JSONObject.parseObject("{\n" +
                    "    \"ret\":1,\n" +
                    "    \"msg\":\"failed\",\n" +
                    "    \"data\":{\n" +
                    "    }\n" +
                    "}\n");
            JSONObject dataJson = JSONObject.parseObject("{}");

            String  rst  = this.queryService.queryEs();

            if (null != rst) {
                dataJson.put("result", rst);

                jsonObject.put("ret", 0);
                jsonObject.put("msg", "success");
                jsonObject.put("data", dataJson);

            }
            LOG.trace("----------------------------------trace");
            return JSONObject.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
        }

        @RequestMapping("/test-logback")
        @ResponseBody
        public Date testLogback() {
            LOG.trace("----------------------------------trace");
            LOG.debug("-----------------------------------debug");
            LOG.info("------------------------------------info");
            LOG.warn("-------------------------------------warn");
            LOG.error("------------------------------------error");
            return new Date();
        }
    }

