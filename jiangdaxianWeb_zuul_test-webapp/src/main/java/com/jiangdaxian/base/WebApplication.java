package com.jiangdaxian.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.ComponentScan;

import com.rule.RibbonConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.jiangdaxian" })
@EnableCircuitBreaker
@EnableFeignClients(basePackages = { "com.jiangdaxian" })
@RibbonClients(value = {
		@RibbonClient(name = "jiangdaxian-gateway-zuul_test_5", configuration = RibbonConfiguration.class) })
public class WebApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebApplication.class, args);
	}
}
