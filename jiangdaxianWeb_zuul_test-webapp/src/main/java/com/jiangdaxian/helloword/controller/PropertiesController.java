package com.jiangdaxian.helloword.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PropertiesController {
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesController.class);
	
	@RequestMapping("/properties")
	@ResponseBody
	public String index() {
		return "aaaaaaaaaaaaaaa";
	}
}
