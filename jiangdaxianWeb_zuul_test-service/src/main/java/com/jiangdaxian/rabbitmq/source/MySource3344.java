package com.jiangdaxian.rabbitmq.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MySource3344 {
	@Output("myOutputJdx33")
	MessageChannel myOutputJdx33();
	@Output("myOutputJdx44")
	MessageChannel myOutputJdx44();
}
