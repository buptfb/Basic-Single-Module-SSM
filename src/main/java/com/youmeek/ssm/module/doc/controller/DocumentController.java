package com.youmeek.ssm.module.doc.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.youmeek.ssm.module.doc.pojo.DocumentInfo;
import com.youmeek.ssm.module.doc.service.DocService;
import com.youmeek.ssm.module.job.pojo.JobInfo;
import com.youmeek.ssm.module.job.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanbo on 2017/4/11.
 */
@Controller
@RequestMapping("/docs")
public class DocumentController {
    private static final Logger LOG = LoggerFactory.getLogger(DocumentController.class);

    @Resource
    private DocService docService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String showEsIndexById(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String[] arrSplit = request.getQueryString().split("[&]");
        HashMap<String, String> mapRequest = new HashMap<>();
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");
            //解析键值
            if (arrSplitEqual.length > 1) {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
            } else {
                if (arrSplitEqual[0] != "") {
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
        if (mapRequest.containsKey("jobid")) {
            //List<DocumentInfo> documentInfos = docService.getByJobID(new Integer(mapRequest.get("jobid")));
            List<DocumentInfo> documentInfos = docService.getByJobID(1);
            if (!documentInfos.isEmpty()) {
                dataJson.put("job_info", documentInfos);
                jsonObject.put("ret", 0);
                jsonObject.put("msg", "success");
                jsonObject.put("data", documentInfos);
            }
        }
        String json = JSONObject.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(json);
        return json;
    }

}
