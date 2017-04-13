package com.youmeek.ssm.module.esindex.controller;

/**
 * Created by fanbo on 2017/4/5.
 */

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.youmeek.ssm.module.esindex.pojo.EsIndex;
import com.youmeek.ssm.module.esindex.service.EsIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/esIndexController")
public class EsIndexController {
    private static final Logger LOG = LoggerFactory.getLogger(EsIndexController.class);

    @Resource
    private EsIndexService esIndexService;

    @RequestMapping("/showEsIndexToJSONById/{indexId}")
    @ResponseBody
    public EsIndex showEsIndexById(@PathVariable("indexId") Integer indexId) {
        EsIndex esIndex = this.esIndexService.getById(indexId);
        return esIndex;
    }


    @RequestMapping(value = "/showEsIndexToJSON",  method = RequestMethod.GET)
    @ResponseBody
    public String showEsIndexALL(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> resultStr = new HashMap<>();
        List<EsIndex> esIndex = esIndexService.getALL();
        resultStr.put("result", esIndex);
        String json = JSONObject.toJSONString(resultStr, SerializerFeature.DisableCircularReferenceDetect);
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
