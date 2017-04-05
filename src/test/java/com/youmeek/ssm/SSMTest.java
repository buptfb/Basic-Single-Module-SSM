package com.youmeek.ssm;

import com.youmeek.ssm.module.user.pojo.SysUser;
import com.youmeek.ssm.module.user.service.SysUserService;
import com.youmeek.ssm.module.esindex.pojo.EsIndex;
import com.youmeek.ssm.module.esindex.service.EsIndexService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.Table;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class SSMTest {

	
	@Resource
	private SysUserService sysUserService;
	@Resource
	private EsIndexService esIndexService;

	@Test
	public void test1() {
		SysUser sysUser = sysUserService.getById(1L);

		System.out.println("--------------------------------" + sysUser.toString());
	}

	@Test
	public void test2(){
		EsIndex esIndex = esIndexService.getById(1);
		System.out.println("################################" + esIndex.toString());
	}
}
