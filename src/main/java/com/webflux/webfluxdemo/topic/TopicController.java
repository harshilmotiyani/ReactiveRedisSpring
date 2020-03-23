package com.webflux.webfluxdemo.topic;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor

public class TopicController {

    @Autowired
    private TopicService topicService;
    @RequestMapping(method = RequestMethod.GET,value = "/topics")
    public Flux<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/topics")
    public Mono<Long> addTopic(@RequestBody Topic topic){
        return topicService.addTopic(topic);

    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/topics")
    public Mono<Boolean> deleteAll(){
        return topicService.deleteAll();
    }
    @RequestMapping(method = RequestMethod.GET,value = "/topics/{id}")
    public Topic getTopic(@PathVariable Long id){
        return topicService.getTopic(id);
    }


}
