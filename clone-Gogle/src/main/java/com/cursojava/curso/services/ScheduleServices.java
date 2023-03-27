package com.cursojava.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Configuration
@EnableScheduling
@Service
public class ScheduleServices {
//    @Autowired
//    private SpiderService spiderService;
//    @Scheduled(cron = "0 0 * * *")
//    public void scheduleCrom(){
//        spiderService.indexPages();
//    }
}
