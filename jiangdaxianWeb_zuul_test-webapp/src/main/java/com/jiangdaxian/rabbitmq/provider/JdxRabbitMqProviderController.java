package com.jiangdaxian.rabbitmq.provider;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jiangdaxian.helloword.controller.PropertiesController;
import com.jiangdaxian.rabbitmq.send.SendService3344;

@RestController
public class JdxRabbitMqProviderController {
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesController.class);

	@Autowired
	private SendService3344 sendService3344;
	/**
	 * 
	 * @return
	 */
	@RequestMapping("jdxRabbitMqProviderController/sendMsg")
	@ResponseBody
	public String sendMsg(HttpServletRequest request) {
		String s = request.getParameter("msg");
		if(s==null) {
			s = "jdxDefaultSendMsg";
		}
		try {
			sendService3344.sendMsg(s);	
			return s;
		}catch(Exception e) {
			LOG.error(e.getMessage(),e);
			return "sendMsg exception";
		}
	}
	
}
