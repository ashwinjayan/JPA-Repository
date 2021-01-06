package com.courseapi.services;

import com.courseapi.models.Topic;
import com.courseapi.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicByName(String name) {
        return topicRepository.findTopicByName(name);
    }

    public Topic getTopicById(long id) {
        return topicRepository.findById(id).get();
    }

    public List<Topic> addTopic(Topic topic) {
        topicRepository.save(topic);
        return getAllTopics();
    }

    public Topic updateTopic(long id, Topic topic) {
        topicRepository.save(topic);
        return getTopicById(id);
    }

    public List<Topic> deleteTopic(long id) {
        topicRepository.deleteById(id);
        return getAllTopics();
    }
}
