package com.jiangdaxian.jdxspringcloud.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jiangdaxian.helloword.controller.PropertiesController;
import com.jiangdaxian.jdxspringcloud.feign.JdxSpringCloudFeignApi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController("jdxSpringCloudComsumerController")
public class JdxSpringCloudComsumerController {
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesController.class);

	@Autowired
	private JdxSpringCloudFeignApi jdxSpringCloudFeignApi;
	
	/**
	 * 通常测试，熔断在FEIGN里面
	 * @return
	 */
	public String testFunctionBreak(HttpServletRequest request) {
		String s = jdxSpringCloudFeignApi.testCanChangeGitConfigProvider("jdxInfo");
		return s;
	}
	
	
	/**
	 * 测试远程调用feign_5的方法，参数为delay，延迟时间会触发熔断机制，熔断为常规熔断，非直接配置在feign
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/testGetFeignByAndDelay")
	@HystrixCommand(fallbackMethod="fallbackTestGetFeignByAndDelay",commandProperties = {
			@com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
			(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
	@ResponseBody
	public String testGetFeignByAndDelay(HttpServletRequest request) throws Exception {
		long delayTime = 0;
		try {
			delayTime = Long.parseLong(request.getParameter("delayTime"));
		}catch(Exception e) {
			LOG.error(e.getMessage(),e);
			delayTime = 10000;
		}
		
		Thread.sleep(delayTime);
		
		LOG.warn("JdxSpringCloudController::testGetFeignBy5AndDelay::getJdxInfo result is:{}", delayTime);
		return "testGetFeignBy5,result is:" + delayTime;
	}
	/**
	 * testGetFeignBy5AndDelay的熔断方法
	 * @param request
	 * @param t
	 * @return
	 */
	public String fallbackTestGetFeignByAndDelay(HttpServletRequest request,Throwable t) {
		String result = "testGetFeignByAndDelay触发熔断,方法为fallbackTestGetFeignByAndDelay";
		return result;
	}
}
