package com.jiangdaxian.jdxspringcloud.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jiangdaxian.helloword.controller.PropertiesController;
import com.jiangdaxian.jdxspringcloud.api5.model.JdxSpringCloudProviderModel;

@RestController()
public class JdxSpringCloudProviderController {
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesController.class);
	@Autowired
	private Environment env;

	/**
	 * 获取可变的在GIT的配置文件值
	 * "jdxInfo"
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("jdxSpringCloudProviderController/testCanChangeGitConfigProvider")
	@ResponseBody
	public String testCanChangeGitConfigProvider(HttpServletRequest request,@RequestParam("key")String key) throws Exception {
		String result = env.getProperty(key, "jdxInfoDefault_jdx");
		int random = new Random().nextInt(2);
		LOG.warn("random:" + random);
		if(random==1) {
			Thread.sleep(15000);
		}
		LOG.warn("JdxSpringCloudController::testCanChangeGitConfig::getJdxInfo result is:{}", result);
		return "testCanChangeGitConfig,jdxInfo result is:" + result;
	}
	

	@RequestMapping("jdxSpringCloudProviderController/testParamJson")
	@ResponseBody
	public String testParamJson(HttpServletRequest request, @RequestBody JdxSpringCloudProviderModel jdxSpringCloudProviderModel) {
		if(jdxSpringCloudProviderModel!=null) {
			return "id:" + jdxSpringCloudProviderModel.getId()+ ";  name:" + jdxSpringCloudProviderModel.getName();
		}else {
			return "jdxSpringCloudProviderModel is null";
		}
	}

}
