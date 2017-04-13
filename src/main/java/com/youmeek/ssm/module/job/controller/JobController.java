package com.youmeek.ssm.module.job.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.youmeek.ssm.module.esindex.pojo.EsIndex;
import com.youmeek.ssm.module.esindex.service.EsIndexService;
import com.youmeek.ssm.module.job.pojo.JobInfo;
import com.youmeek.ssm.module.job.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanbo on 2017/4/11.
 */
@SuppressWarnings("ALL")
@Controller
@RequestMapping("/jobinfo")
public class JobController {
    private static final Logger LOG = LoggerFactory.getLogger(JobController.class);

    @Resource
    private JobService jobService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String showEsIndexById(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        //解析
        String[] arrSplit = request.getQueryString().split("[&]");
        HashMap<String, String> mapRequest = new HashMap<>();
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");
            //解析出键值
            if (arrSplitEqual.length > 1) {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
            } else {
                if (arrSplitEqual[0] != "") {
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        JSONObject jsonObject = JSONObject.parseObject("{\n" +
                "    \"ret\":1,\n" +
                "    \"msg\":\"failed\",\n" +
                "    \"data\":{\n" +
                "    }\n" +
                "}\n");
        JSONObject dataJson = JSONObject.parseObject("{}");
        if (mapRequest.containsKey("username")) {
            Map<String, Object> resultStr = new HashMap<>();
            List<JobInfo> jobInfo = jobService.getByUserName(mapRequest.get("username"));
            resultStr.put("result", jobInfo);
            if (!jobInfo.isEmpty()) {
                dataJson.put("job_info", jobInfo);
                jsonObject.put("ret", 0);
                jsonObject.put("msg", "success");
                jsonObject.put("data", jobInfo);
            }
        }
        String json = JSONObject.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(json);
        return json;
    }


    @RequestMapping("/test-logback")
    @ResponseBody
    public Date testLogback() {
        LOG.trace("----------------------------------trace");
        LOG.debug("-----------------------------------debug");
        LOG.info("-----------------------------------info");
        LOG.warn("-----------------------------------warn");
        LOG.error("-----------------------------------error");
        return new Date();
    }
}
