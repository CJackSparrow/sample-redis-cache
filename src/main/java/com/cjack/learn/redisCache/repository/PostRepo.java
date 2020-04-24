package com.cjack.learn.redisCache.repository;

import com.cjack.learn.redisCache.repository.entity.Post;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends PagingAndSortingRepository<Post, String>, JpaSpecificationExecutor<Post> {

    @Caching(
            evict = {
                    @CacheEvict(value = "findByName", allEntries = true)
                    , @CacheEvict(value = "findById", allEntries = true)
            }
    )
    Post save(Post post);

    @Cacheable(value = "findById", key = "#id", unless = "#result == null")
    Optional<Post> findById(String id);

    @Cacheable(value = "findByName", key = "#name", unless = "#result == null")
    List<Post> findByName(String name);
}
