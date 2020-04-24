package com.cjack.learn.redisCache.service;

import com.cjack.learn.redisCache.repository.PostRepo;
import com.cjack.learn.redisCache.repository.entity.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public void create(Post post){
        log.info("create");
        postRepo.save(post);
    }

    public void update(Post post){
        log.info("update");
        postRepo.save(post);
    }

    public List<Post> findByName(String name){
        log.info("findByName");
        return postRepo.findByName(name);
    }

    public Post findById(String id){
        log.info("findById");
        return postRepo.findById(id).orElse(null);
    }
}
