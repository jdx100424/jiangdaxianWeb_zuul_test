package com.jiangdaxian.jdxspringcloud.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jiangdaxian.helloword.controller.PropertiesController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController("jdxSpringCloudComsumerController")
public class JdxSpringCloudComsumerController {
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesController.class);


	/**
	 * 测试远程调用feign_5的方法，参数为delay，延迟时间会触发熔断机制，熔断为常规熔断，非直接配置在feign
	 * @param request
	 * @return
	 */
	@RequestMapping("/testGetFeignBy5AndDelay")
	@HystrixCommand(fallbackMethod="fallbackTestGetFeignBy5AndDelay",commandProperties = {
			@com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
			(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
	@ResponseBody
	public String testGetFeignBy5AndDelay(HttpServletRequest request) {
		long delayTime = Long.parseLong(request.getParameter("delayTime"));
		String result = null;
		LOG.warn("JdxSpringCloudController::testGetFeignBy5AndDelay::getJdxInfo result is:{}", result);
		return "testGetFeignBy5,result is:" + result;
	}
	/**
	 * testGetFeignBy5AndDelay的熔断方法
	 * @param request
	 * @param t
	 * @return
	 */
	public String fallbackTestGetFeignBy5AndDelay(HttpServletRequest request,Throwable t) {
		String result = "testGetFeignBy5AndDelay触发熔断,方法为fallbackTestGetFeignBy5AndDelay";
		return result;
	}
}
