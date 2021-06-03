package com.amsidh.mvc.springreactivestreamingapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@RequiredArgsConstructor
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringReactiveStreamingAppApplicationTests {

    private final WebTestClient webTestClient;

    @Test
    public void testGetShareStream(){

    }



    @Test
    void contextLoads() {
    }

}
