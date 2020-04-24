package com.cjack.learn.redisCache.controller;

import com.cjack.learn.redisCache.model.SearchPost;
import com.cjack.learn.redisCache.repository.entity.Post;
import com.cjack.learn.redisCache.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class Controller {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/name/{name}")
    public List<Post> findByName(@PathVariable(value = "name") String name) {
        return postService.findByName(name);
    }

    @GetMapping(value = "/{id}")
    public Post findById(@PathVariable(value = "id") String id) {
        return postService.findById(id);
    }

    @GetMapping("/search")
    public Post search(@Valid SearchPost post) {
        return postService.findById(post.getId());
    }

    @PostMapping
    public void create(@RequestBody Post post) {
        postService.create(post);
    }

    @PutMapping
    public void update(@RequestBody Post post) {
        postService.update(post);
    }
}
