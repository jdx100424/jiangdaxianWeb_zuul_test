package com.jiangdaxian.jdxspringcloud.feign.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jiangdaxian.jdxspringcloud.api.model.JdxSpringCloudProviderModel;
import com.jiangdaxian.jdxspringcloud.feign.JdxSpringCloudFeignApi;

import feign.hystrix.FallbackFactory;

@Component
public class JdxSpringCloudFeignFallback implements FallbackFactory<JdxSpringCloudFeignApi> {
	private static final Logger LOG = LoggerFactory.getLogger(JdxSpringCloudFeignFallback.class);
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

	public JdxSpringCloudFeignApi create(Throwable t) {
		LOG.error("jdx:"+t.getMessage(),t);
		return jdxSpringCloudFeignApi;
	}

}
