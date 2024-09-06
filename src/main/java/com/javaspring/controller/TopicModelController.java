package com.javaspring.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.entity.TopicModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
@RestController
@RequestMapping("/topics")
public class TopicModelController {
	private List<TopicModel> topicList = new ArrayList<>();
	 
    // Your methods like getTopicByID, addTopic, updateTopic will go here
    
    // You can initialize the list with some data in a constructor if needed
    public TopicModelController() {
        topicList.add(new TopicModel("1", "Spring Boot", "Introduction to Spring Boot"));
        topicList.add(new TopicModel("2", "Java", "Basic Java Concepts"));
        topicList.add(new TopicModel("3", "REST API", "Developing RESTful APIs"));
    }
    
    @GetMapping("/topics")
    public List<TopicModel> getAllTopics() {
        return topicList;
    }
 
	@GetMapping("{id}")
	public TopicModel getTopicByID(@PathVariable("id") String id) {
	    TopicModel t = null;
	    for (TopicModel topic : topicList) {
	        if (topic.getId().equals(id)) {
	            t = topic;
	            break;
	        }
	    }
	    return t;
	}
 
	@PostMapping("/addTopic")
	public TopicModel addTopic(@RequestBody TopicModel topic) {
	    topicList.add(topic);  // add topic object into arraylist
	    return topic;
	}
 
	@PutMapping("{id}")
	public TopicModel updateTopic(@PathVariable("id") String id, @RequestBody TopicModel topic) {
	    for (TopicModel t : topicList) {
	        if (t.getId().equals(id)) {
	            t.setTopicName(topic.getTopicName());
	        }
	    }
	    return topic;
	}
	
	@DeleteMapping("{id}")
	public TopicModel deleteTopic(@PathVariable("id") String id) {
		Iterator<TopicModel> topicIterator = topicList.iterator();
	    while (topicIterator.hasNext()) {
	    	TopicModel t = topicIterator.next();
	        if (t.getId().equals(id)) {
	            topicIterator.remove();
	            return t;
	        }
	    }
	    return null;
	}
 
}

//public static List<TopicModel> topicList = new ArrayList<>();
//
//// Your methods like getTopicByID, addTopic, updateTopic will go here
//
//// You can initialize the list with some data in a constructor if needed
//static {
//    topicList.add(new TopicModel("1", "Java", "Basic"));
//    topicList.add(new TopicModel("2", "Variable", "Basic"));
//    topicList.add(new TopicModel("3", "OOP", "Intermediate"));
//    topicList.add(new TopicModel("4", "Servlet", "Advanced"));
//    topicList.add(new TopicModel("5", "JSP", "Advanced"));
//    topicList.add(new TopicModel("6", "Spring Core", "Advanced"));
//    topicList.add(new TopicModel("7", "Spring MVC", "Advanced"));
//}
 