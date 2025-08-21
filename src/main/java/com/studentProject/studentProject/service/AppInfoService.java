package com.studentProject.studentProject.service;

import org.springframework.stereotype.Service;

import com.studentProject.studentProject.config.AppProperties;

@Service
public class AppInfoService {
    private final AppProperties appProperties;

    public AppInfoService(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public String getAppInfo() {
        return "App: " + appProperties.getName() +
               " | Version: " + appProperties.getVersion() +
               " | FeatureX enabled: " + appProperties.isEnableFeatureX();
    }
}
