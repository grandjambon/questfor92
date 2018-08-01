package com.pj.quest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages={"com.pj.quest.springboot"})
public class QuestWebWarApp extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(QuestWebWarApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(QuestWebWarApp.class, args);
    }
}
