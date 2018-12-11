package com.jiangdaxian.jdxspringcloud.controller;

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
import com.jiangdaxian.jdxspringcloud.api.model.JdxSpringCloudProviderModel;

@RestController("jdxSpringCloudProviderController")
public class JdxSpringCloudProviderController {
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesController.class);
	@Autowired
	private Environment env;

	/**
	 * 获取可变的在GIT的配置文件值
	 * "jdxInfo"
	 * @return
	 */
	@RequestMapping("/testCanChangeGitConfigProvider")
	@ResponseBody
	public String testCanChangeGitConfigProvider(HttpServletRequest request,@RequestParam("key")String key) {
		String result = env.getProperty(key, "jdxInfoDefault_jdx");
		LOG.warn("JdxSpringCloudController::testCanChangeGitConfig::getJdxInfo result is:{}", result);
		return "testCanChangeGitConfig,jdxInfo result is:" + result;
	}
	

	@RequestMapping("/testParamJson")
	@ResponseBody
	public String testParamJson(HttpServletRequest request, @RequestBody JdxSpringCloudProviderModel jdxSpringCloudProviderModel) {
		if(jdxSpringCloudProviderModel!=null) {
			return "id:" + jdxSpringCloudProviderModel.getId()+ ";  name:" + jdxSpringCloudProviderModel.getName();
		}else {
			return "jdxSpringCloudProviderModel is null";
		}
	}

}
