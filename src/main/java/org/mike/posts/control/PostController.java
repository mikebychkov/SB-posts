package org.mike.posts.control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mike.posts.model.Post;
import org.mike.posts.service.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private static final Logger log = LogManager.getLogger(PostController.class);

    @Autowired
    private PostSvc svc;

    @GetMapping("/posts")
    public List<Post> getAll() {
        return svc.getAll();
    }

    @GetMapping("/posts/{filter}/{value}")
    public List<Post> getByFilter(@PathVariable String filter, @PathVariable String value) {
        return svc.getByFilter(filter, value);
    }

    @PostMapping("/posts")
    public Post add(@RequestBody Post post) {
        return svc.add(post);
    }
}
