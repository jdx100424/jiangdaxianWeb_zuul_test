package com.jiangdaxian.jdxspringcloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.jiangdaxian.jdxspringcloud.api5.JdxSpringCloudProviderApi5;
import com.jiangdaxian.jdxspringcloud.feign.fallback.JdxSpringCloudFeignFallback;

@FeignClient(value = JdxSpringCloudProviderApi5.SERVICE_ID, fallbackFactory=JdxSpringCloudFeignFallback.class)
public interface JdxSpringCloudFeignApi extends JdxSpringCloudProviderApi5{
	
}
