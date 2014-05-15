package com.freecharge.interview.http.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class CountModel {
    private String id = UUID.randomUUID().toString();

    @JsonProperty
    private Integer count;

    public Integer getCount(){
        return count;
    }

    public void setCount(Integer count){
        this.count = count;
    }
}
