package com.springframework.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.springframework.data.test.TestDataEventOrderApplication;
import com.springframework.data.test.model.Foo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestDataEventOrderApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class DataEventOrderTest {
    
    private static final String TEST_NAME = "testName";

    @Autowired
    private TestRestTemplate restTemplate;
    
    @LocalServerPort
    int serverPort;
    
    Map<String, String> headers;
    
    @Before
    public void setup(){
        headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
    }

    @Test
    @SuppressWarnings("unchecked")
    public void test() {
        
        log.debug("ServerPort: " + serverPort);
        
        Foo foo = new Foo();
        foo.setName(TEST_NAME);
        
        ResponseEntity<Foo> response = restTemplate.postForEntity("http://localhost:" + serverPort + "/test/foos", foo, Foo.class, Collections.EMPTY_MAP);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        Foo fooCreated = response.getBody();
        assertEquals(fooCreated.getName(), TEST_NAME);
        assertNotNull(fooCreated.getS3());
        assertNotNull(fooCreated.getS2());
        assertNotNull(fooCreated.getS1());
    }

}
