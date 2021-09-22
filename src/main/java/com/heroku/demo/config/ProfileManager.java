package com.heroku.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public class ProfileManager {

    @Autowired
    private Environment environment;


    @Value("${spring.profiles.active:}")
    private String activeProfile;

    public void getActiveProfiles() {
        for(String profileName : environment.getActiveProfiles()) {
            System.out.println("Current Active Profile is :> " + profileName);
        }
    }
}
