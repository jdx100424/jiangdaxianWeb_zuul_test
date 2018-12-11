package com.jiangdaxian.jdxspringcloud.feign.fallback;

import com.jiangdaxian.jdxspringcloud.api.model.JdxSpringCloudProviderModel;
import com.jiangdaxian.jdxspringcloud.feign.JdxSpringCloudFeignApi;

import feign.hystrix.FallbackFactory;

public class JdxSpringCloudFeignFallback implements FallbackFactory<JdxSpringCloudFeignApi> {

	private JdxSpringCloudFeignApi jdxSpringCloudFeignApi;

	public JdxSpringCloudFeignFallback() {
		jdxSpringCloudFeignApi = new JdxSpringCloudFeignApi() {
			public String testCanChangeGitConfigProvider(String arg0) {
				return "jdx_testCanChangeGitConfigProvider:熔断";
			}
			public String testParamJson(JdxSpringCloudProviderModel arg0) {
				return "jdx_testParamJson:熔断";
			}
		};
	}

	public JdxSpringCloudFeignApi create(Throwable cause) {
		return jdxSpringCloudFeignApi;
	}

}
