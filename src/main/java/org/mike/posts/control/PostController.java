package org.mike.posts.control;

import org.mike.posts.model.Post;
import org.mike.posts.service.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

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
