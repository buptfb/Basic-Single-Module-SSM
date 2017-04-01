package com.youmeek.ssm.module.esindex.controller;

/**
 * Created by fanbo on 2017/4/5.
 */

import com.youmeek.ssm.module.esindex.pojo.EsIndex;
import com.youmeek.ssm.module.esindex.service.EsIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

public class EsIndexController {
    private static final Logger LOG = LoggerFactory.getLogger(EsIndexController.class);

    @Resource
    private EsIndexService esIndexService;

/*    @RequestMapping("/showEsIndexToJspById/{indexId}")
    public String showUser(Model model,@PathVariable("indexId") Long userId){
        SysUser user = this.sysUserService.getById(indexId);
        model.addAttribute("user", user);
        return "showUser";
    }*/

    @RequestMapping("/showEsIndexToJSONById/{indexId}")
    @ResponseBody
    public EsIndex showEsIndex(@PathVariable("indexId") Integer userId){
        EsIndex esIndex = esIndexService.getById(userId);
        return esIndex;
    }


    @RequestMapping("/test-logback")
    @ResponseBody
    public Date testLogback(){
        LOG.trace("----------------------------------trace");
        LOG.debug("-----------------------------------debug");
        LOG.info("-----------------------------------info");
        LOG.warn("-----------------------------------warn");
        LOG.error("-----------------------------------error");
        return new Date();
    }
}
