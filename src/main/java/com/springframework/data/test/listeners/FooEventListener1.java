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
@Order(3)
@RepositoryEventHandler(Foo.class)
public class FooEventListener1 {
    
    @Order(3)
    @HandleBeforeCreate
    @HandleBeforeSave
    public void setS1(Foo foo){
        
        log.info("Event S1");
        
        if(foo.getS2() != null
        && foo.getS3() != null){
            log.info("Setting S1");
            foo.setS2(UUID.randomUUID().toString());
        }

        
    }

}
