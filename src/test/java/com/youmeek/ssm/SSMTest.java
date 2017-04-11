package com.youmeek.ssm;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.youmeek.ssm.module.doc.pojo.DocumentInfo;
import com.youmeek.ssm.module.doc.service.DocService;
import com.youmeek.ssm.module.job.service.JobService;
import com.youmeek.ssm.module.login.service.LoginService;
import com.youmeek.ssm.module.user.pojo.SysUser;
import com.youmeek.ssm.module.user.service.SysUserService;
import com.youmeek.ssm.module.esindex.pojo.EsIndex;
import com.youmeek.ssm.module.esindex.service.EsIndexService;

import com.youmeek.ssm.module.job.pojo.JobInfo;
import com.youmeek.ssm.module.job.service.JobService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.Table;
import javax.print.Doc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class SSMTest {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private EsIndexService esIndexService;
    @Resource
    private LoginService loginService;
    @Resource
    private JobService jobService;
    @Resource
    private DocService docService;

    @Test
    public void test1() {
        SysUser sysUser = sysUserService.getById(1L);

        System.out.println("--------------------------------" + sysUser.toString());
    }

    @Test
    public void test2() {
        EsIndex esIndex = esIndexService.getById(1);
        System.out.println("################################" + esIndex.toString());
    }

    @Test
    public void test3() {
        Map<String, Object> resultStr = new HashMap<>();
        List<EsIndex> esIndex = esIndexService.getALL();
        resultStr.put("result", esIndex);
        String json = JSONObject.toJSONString(resultStr, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(json);
    }

    @Test
    public void test4() {
        System.out.println(loginService.checkAccount("fanbo", "imoran@0505"));
    }


    @Test
    public void test5() {
        Map<String, Object> resultStr = new HashMap<>();
        List<JobInfo> jobInfo = jobService.getByUserName("fanbo");
        resultStr.put("result", jobInfo);
        String json = JSONObject.toJSONString(resultStr, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(json);
    }

    @Test
    public void test6(){
        Map<String, Object> resultStr = new HashMap<>();
        List<DocumentInfo> documentInfos = docService.getByJobID(1);
        resultStr.put("result", documentInfos);
        String json = JSONObject.toJSONString(resultStr, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(json);

    }
}
