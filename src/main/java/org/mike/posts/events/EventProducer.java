package org.mike.posts.events;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mike.posts.model.Post;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventProducer {

    private final Logger log = LogManager.getLogger(EventProducer.class);

    @Autowired
    private RabbitTemplate template;

    public void sendTo(String queue, Post post) {
        log.info("### SENDING MESSAGE: {}", post);
        template.convertAndSend(queue, post);
    }
}
