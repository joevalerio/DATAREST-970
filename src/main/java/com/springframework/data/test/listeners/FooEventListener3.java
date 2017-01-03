package com.springframework.data.test.listeners;

import java.util.UUID;

import org.springframework.core.annotation.Order;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.springframework.data.test.model.Foo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(1)
@RepositoryEventHandler(Foo.class)
public class FooEventListener3 {
    
    @Order(1)
    @HandleBeforeCreate
    @HandleBeforeSave
    public void setS3(Foo foo){

        log.info("Event S3");

        if(foo.getS1() == null
        && foo.getS2() == null){
            log.info("Setting S3");
            foo.setS3(UUID.randomUUID().toString());
        }
        
    }

}
