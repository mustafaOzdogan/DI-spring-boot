package com.example.dependencyinjectionspringboot.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig
public class ConfigIT
{
    private ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Test
    public void givenAppContext_WhenInjected_ThenItShouldNotBeNull() {
        assertNotNull(applicationContext, "ApplicationContext should not be null.");
    }
}
