package com.springframework.data.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Foo {

    @Id 
    @GenericGenerator(name="uuid", strategy = "uuid2")
    @GeneratedValue(generator="uuid")
    private String id;
    
    private String name;
    
    private String s1;
    
    private String s2;
    
    private String s3;
    
}
