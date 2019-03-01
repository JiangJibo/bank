/**
 * Copyright(C) 2017 MassBot Co. Ltd. All rights reserved.
 *
 */
package com.bob.kafka.kafka.consumer;

import com.bob.kafka.kafka.entity.KafkaMessageEntity;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;

/**
 * @since 2017年7月1日 上午11:13:25
 * @version $Id$
 * @author JiangJibo
 *
 */
// @Component
@KafkaListener(groupId = "lanboal", topics = "lanboal")
public class AnnotatedClassKafkaConsumer {

	@KafkaHandler
	public void consume(Message<KafkaMessageEntity> message) {

	}

}
