package com.courseapi.controllers;

import com.courseapi.exception.ApiRequestException;
import com.courseapi.models.Topic;
import com.courseapi.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        throw new ApiRequestException("Cannot get all topics");
        //return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{name}")
    public Topic getTopicByName(@PathVariable String name) {
        return topicService.getTopicByName(name);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public List<Topic> addTopic(@RequestBody Topic topic) {
        return topicService.addTopic(topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public Topic updateTopic(@RequestBody Topic topic, @PathVariable long id) {
        return topicService.updateTopic(id, topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public List<Topic> deleteTopic(@PathVariable long id) {
        return topicService.deleteTopic(id);
    }

}
