package com.javaspring.entity;

import org.springframework.stereotype.Component;
 
import lombok.Data;

@Data
public class TopicModel {
    private String id;
    private String topicName;
    private String description;
 
    // Constructor
    public TopicModel(String id, String topicName, String description) {
        this.id = id;
        this.topicName = topicName;
        this.description = description;
    }
 
    // Getters and Setters
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getTopicName() {
        return topicName;
    }
 
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
}
 
 