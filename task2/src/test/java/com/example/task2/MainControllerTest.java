package com.example.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MainControllerTest {
    @Autowired
    private RestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void testIncreaseValueMethod_whenFiveThreadsStarted_shouldGetTheWrongAnswer() throws InterruptedException {
        var numberOfRemainingThreads = 5;

        while (numberOfRemainingThreads > 0) {

            Thread thread = new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    restTemplate.postForEntity("http://localhost:" + port + "/increase", "", String.class);
                }
            });
            thread.start();

            numberOfRemainingThreads--;
        }

        Thread.sleep(10_000);

        var actualResult = restTemplate.getForEntity("http://localhost:" + port + "/get", String.class);
        Assertions.assertEquals(500, Integer.valueOf(actualResult.getBody()));
    }


}
