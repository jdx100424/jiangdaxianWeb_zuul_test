package com.jiangdaxian.rabbitmq.source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface MySink3344 {
	@Input("myOutputJdx33")
	MessageChannel myOutputJdx33();
	
	@Input("myOutputJdx44")
	MessageChannel myOutputJdx44();
}
