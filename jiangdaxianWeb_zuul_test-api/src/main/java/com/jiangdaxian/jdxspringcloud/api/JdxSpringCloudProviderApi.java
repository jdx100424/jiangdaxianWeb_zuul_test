package com.jiangdaxian.jdxspringcloud.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jiangdaxian.jdxspringcloud.api.model.JdxSpringCloudProviderModel;

public interface JdxSpringCloudProviderApi {
	public static final String CONTEXT_PATH = "test4";
	public static final String SERVICE_ID = "jiangdaxian-gateway-zuul_test_4";

	/**
	 * 测试获取可变的在GIT的配置文件值,"jdxInfo"
	 * @param key,测试时候填写"jdxInfo"
	 * @return
	 */
	@RequestMapping("/" + CONTEXT_PATH + "/jdxSpringCloudProviderController/testCanChangeGitConfigProvider")
	public String testCanChangeGitConfigProvider(@RequestParam(value = "key", defaultValue = "def")String key);
	
	/**
	 * 测试传送JSON参数
	 * @param jdxSpringCloudProviderModel
	 * @return
	 */
	@RequestMapping("/" + CONTEXT_PATH + "/jdxSpringCloudProviderController/testParamJson")
	public String testParamJson(@RequestBody JdxSpringCloudProviderModel jdxSpringCloudProviderModel);
}
