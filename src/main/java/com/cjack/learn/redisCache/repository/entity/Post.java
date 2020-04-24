package com.cjack.learn.redisCache.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "post")
public class Post implements Serializable {

    @Id
    private String id;

    private String name;
    private String content;

    @PrePersist
    public void ensureId(){
        try{
            UUID.fromString(id);
        }catch (Exception e){
            this.id = UUID.randomUUID().toString();
        }
    }
}
