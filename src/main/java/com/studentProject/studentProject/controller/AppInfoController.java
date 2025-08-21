package com.studentProject.studentProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentProject.studentProject.service.AppInfoService;

@RestController
public class AppInfoController {
    private final AppInfoService appInfoService;


    public AppInfoController(AppInfoService appInfoService) {
        this.appInfoService =  appInfoService;
    }


    @GetMapping("/app-info")
    public String getAppInfo() {
        return appInfoService.getAppInfo();
    }
}
