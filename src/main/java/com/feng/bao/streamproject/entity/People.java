package com.feng.bao.streamproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class People {
    private String name;
    private Integer age;
    private String city;
    public People(String name,String city){
        this.name=name;
        this.city=city;
    }
}
