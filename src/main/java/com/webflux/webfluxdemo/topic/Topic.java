package com.webflux.webfluxdemo.topic;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RedisHash("Topic")
@Getter @Setter
public class Topic implements Serializable {
    @Id
    private Long id;
    private String name;
    private String description;
    public Topic(Long id,String name,String description){
        this.id= id;
        this.name = name;
        this.description = description;
    }
    public Long getId(){
        return this.id;
    }

}
