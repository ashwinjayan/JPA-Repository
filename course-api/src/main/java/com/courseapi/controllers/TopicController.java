package com.courseapi.controllers;

import com.courseapi.exception.ApiRequestException;
import com.courseapi.models.Topic;
import com.courseapi.services.TopicService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public List<Topic> getAllTopics() {
        //throwing a custom exception in spring cloud to return custom responses to the client side
        //throw new ApiRequestException("Cannot get all topics");
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/topics/{name}", method = RequestMethod.GET)
    @ApiOperation(value = "Finds the topics by name",
            notes = "Provide a name to look up specific topic from DB",
            response = Topic.class)
    public Topic getTopicByName(@ApiParam(value = "Name value for the topic you need to retrieve", required = true)
                                    @PathVariable String name) {
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
