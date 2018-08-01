package com.pj.quest.springboot.controller;

import com.pj.quest.data.QuestDataManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@SuppressWarnings("unused")
@Configuration
public class QuestConfiguration {

    @Bean
    @Scope("singleton")
    public QuestDataManager getQuestDataManager() {
        return new QuestDataManager();
    }
}
