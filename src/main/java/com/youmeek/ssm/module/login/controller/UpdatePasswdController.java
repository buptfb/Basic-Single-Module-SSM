package com.youmeek.ssm.module.login.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.youmeek.ssm.module.login.pojo.UserInfo;
import com.youmeek.ssm.module.login.service.LoginService;
import com.youmeek.ssm.module.login.service.UpdatePasswdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fanbo on 2017/4/20.
 * 更新密码接口
 */

@Controller
@RequestMapping("/updatepasswd")
public class UpdatePasswdController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private UpdatePasswdService updatePasswdService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String check(HttpServletRequest request) {
        //request.setHeader("Access-Control-Allow-Origin", "*");
        //解析参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        JSONObject jsonObject = JSONObject.parseObject("{\n" +
                "    \"ret\":1,\n" +
                "    \"msg\":\"failed\",\n" +
                "    \"data\":{\n" +
                "    }\n" +
                "}\n");
        JSONObject dataJson = JSONObject.parseObject("{}");
        UserInfo userInfo = this.updatePasswdService.setPasswd(username, password);
        if (null != userInfo) {
            dataJson.put("user_info", userInfo);
            jsonObject.put("ret", 0);
            jsonObject.put("msg", "success");
            jsonObject.put("data", dataJson);
        }else{
            dataJson.put("user_info", null);
            jsonObject.put("ret", 0);
            jsonObject.put("msg", "failed");
            jsonObject.put("data", dataJson);
        }
        return JSONObject.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
    }


}
