package com.natay.saysthat.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTasks {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    private final RestTemplate restTemplate;

    public ScheduledTasks(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedDelay = 2*1000,initialDelay = 5000)
    public void cacheEvictEveryTenMinutes(){
        String fooResourceUrl = "http://localhost:8080/saveFromSite";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(fooResourceUrl , String.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            LOGGER.info("Istek Atildi.");
        }else {
            LOGGER.error("Istek Atilmadi.");
        }

    }

}
