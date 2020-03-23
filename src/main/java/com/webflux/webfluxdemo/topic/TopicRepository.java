package com.webflux.webfluxdemo.topic;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TopicRepository {

    private final ReactiveRedisOperations<String, Topic> reactiveRedisOperations;

    public TopicRepository(ReactiveRedisOperations<String, Topic> reactiveRedisOperations) {
        this.reactiveRedisOperations = reactiveRedisOperations;
    }

    public Flux<Topic> getAllTopics() {
        return this.reactiveRedisOperations.opsForList().range("topic",0,-1);

    }

    public Mono<Long> addTopic(Topic topic) {
        return this.reactiveRedisOperations.opsForList().rightPush("topic",topic);
    }

    public Mono<Boolean> deleteAll() {
        return this.reactiveRedisOperations.opsForList().delete("topic");
    }

    public Topic getTopic(Long id) {
        return null;
    }
}
