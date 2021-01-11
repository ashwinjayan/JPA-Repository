package com.courseapi.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "topic")
@ApiModel(description = "Details about the Topic")
public class Topic {

    @Id
    @GeneratedValue()
    @ApiModelProperty(notes = "The unique id of the Topic")
    private Long id;
    private String name;
    private String description;

    /*@OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
    private Set<Course> courses;*/

    public Topic() {
    }

    public Topic(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
