package org.mike.posts.service;

import org.mike.posts.model.Post;
import org.mike.posts.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSvc {

    @Autowired
    private PostRepo repo;

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
        return repo.save(post);
    }
}
