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
@Order(2)
@RepositoryEventHandler(Foo.class)
public class FooEventListener2 {
    
    @Order(2)
    @HandleBeforeCreate
    @HandleBeforeSave
    public void setS2(Foo foo){

        log.info("Event S2");
        
        if(foo.getS3() != null
        && foo.getS1() == null){
            log.info("Setting S2");
            foo.setS2(UUID.randomUUID().toString());
        }
        
    }

}
