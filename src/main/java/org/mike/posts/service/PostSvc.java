package org.mike.posts.service;

import org.mike.posts.events.EventProducer;
import org.mike.posts.model.Post;
import org.mike.posts.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSvc {

    @Autowired
    private PostRepo repo;

    @Value("${my.event.queue}")
    private String queue;

    @Autowired
    private EventProducer producer;

    public List<Post> getAll() {
        return repo.findAllByOrderByName();
    }

    public List<Post> getByFilter(String filter, String value) {

        List<Post> rsl = null;

        if("name".equals(filter)) {
            rsl = repo.findAllByNameContainingOrderByName(value);
        } else if ("description".equals(filter)) {
            rsl = repo.findAllByDescriptionContainingOrderByName(value);
        }

        return rsl;
    }

    public Post add(Post post) {
        producer.sendTo(queue, post);
        return repo.save(post);
    }
}
