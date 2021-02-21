package org.mike.posts.kafka;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.mike.posts.model.Post;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.messaging.Source;
//import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageSource {

//    @Autowired
//    private Source source;
//
//    private static final Logger log = LogManager.getLogger(KafkaMessageSource.class);
//
//    public void publishMessage(Post post) {
//        log.info("### SENDING KAFKA MESSAGE: {}", post);
//        ChangeModel change =  ChangeModel.of(post.getName(), post.getDescription());
//        source.output().send(MessageBuilder.withPayload(change).build());
//    }
}
