package com.jiangdaxian.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.jiangdaxian.rabbitmq.bean.MyBean;
import com.jiangdaxian.rabbitmq.source.MySink3344;

@EnableBinding(MySink3344.class)
public class RecieveService3344 {
	private static final Logger LOG = LoggerFactory.getLogger(RecieveService3344.class);
	@StreamListener("myOutputJdx33")
	public void myOutputJdx33(Object payload) {
		System.out.println("myOutputJdx33:" +System.currentTimeMillis()+"_" +payload);
		LOG.error("myOutputJdx33:" +System.currentTimeMillis()+"_" +payload);
	}
	@StreamListener("myOutputJdx44")
	public void myOutputJdx44(MyBean myBean) {
		System.out.println("myOutputJdx44:" +System.currentTimeMillis()+"_" +myBean.getId() + "_" + myBean.getName());
		LOG.error("myOutputJdx44:" +System.currentTimeMillis()+"_" +myBean.getId() + "_" + myBean.getName());
	}
}
