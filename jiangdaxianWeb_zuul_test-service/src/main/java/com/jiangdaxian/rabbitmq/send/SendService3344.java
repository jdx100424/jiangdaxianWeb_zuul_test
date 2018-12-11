package com.jiangdaxian.rabbitmq.send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import com.jiangdaxian.rabbitmq.bean.MyBean;
import com.jiangdaxian.rabbitmq.source.MySource3344;

@EnableBinding(MySource3344.class)
public class SendService3344 {
	@Autowired
	private MySource3344 mySource3344;

	public void sendMsg(String msg) {
		mySource3344.myOutputJdx33().send(MessageBuilder.withPayload(msg).build());
		MyBean myBean = new MyBean();
		myBean.setId(System.currentTimeMillis());
		myBean.setName(msg);
		mySource3344.myOutputJdx44().send(MessageBuilder.withPayload(myBean).build());
	}
}
