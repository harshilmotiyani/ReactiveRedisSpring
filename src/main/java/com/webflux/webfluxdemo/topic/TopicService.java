package com.webflux.webfluxdemo.topic;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public Flux<Topic> getAllTopics() {
        return topicRepository.getAllTopics();
    }

    public Mono<Long> addTopic(Topic topic) {
        return topicRepository.addTopic(topic);

    }

    public Mono<Boolean> deleteAll() {
        return topicRepository.deleteAll();
    }

    public Topic getTopic(Long id) {
        return topicRepository.getTopic(id);
    }
}

