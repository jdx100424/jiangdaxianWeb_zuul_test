package com.rule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esotericsoftware.minlog.Log;
import com.jiangdaxian.helloword.controller.PropertiesController;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class RibbonConfiguration {
	private static final Logger LOG = LoggerFactory.getLogger(RibbonConfiguration.class);
	@Autowired
	IClientConfig config;

	@Bean
	public IRule myRule(IClientConfig config) {
		Log.info("jiangdaxian-gateway-zuul_test_5使用RibbonConfiguration负载均衡算法");
		return new MySelfRule();
	}

}
