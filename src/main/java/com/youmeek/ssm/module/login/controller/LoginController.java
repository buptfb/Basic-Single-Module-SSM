package com.youmeek.ssm.module.login.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.youmeek.ssm.module.login.pojo.UserInfo;
import com.youmeek.ssm.module.login.pojo.UserInfo;
import com.youmeek.ssm.module.login.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by fanbo on 2017/4/8.
 */

@Controller
@RequestMapping("/login")
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public String check(HttpServletRequest request) {
        //解析参数
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
        if (mapRequest.containsKey("username") && mapRequest.containsKey("password")) {
            UserInfo userInfo = this.loginService.checkAccount(mapRequest.get("username"), mapRequest.get("password"));

            if (null != userInfo) {
                dataJson.put("user_info", userInfo);

                jsonObject.put("ret", 0);
                jsonObject.put("msg", "success");
                jsonObject.put("data", dataJson);
            }
        }
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
