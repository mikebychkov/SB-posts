package org.mike.posts.repo;

import org.mike.posts.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, String> {
    List<Post> findAllByOrderByName();
    List<Post> findAllByNameContainingOrderByName(String val);
    List<Post> findAllByDescriptionContainingOrderByName(String val);
}
