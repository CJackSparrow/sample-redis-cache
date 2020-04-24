package com.cjack.learn.redisCache.model;

import com.cjack.learn.redisCache.valid.ValidPostId;
import lombok.Data;

@Data
public class SearchPost {

    @ValidPostId
    private String id;
}
