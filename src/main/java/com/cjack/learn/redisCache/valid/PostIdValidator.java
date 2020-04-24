package com.cjack.learn.redisCache.valid;

import com.cjack.learn.redisCache.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class PostIdValidator implements ConstraintValidator<ValidPostId, String> {

    @Autowired
    private PostService postService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        log.info("isValid {}", s);
        if(postService.findById(s) != null) return true;

        return false;
    }
}
