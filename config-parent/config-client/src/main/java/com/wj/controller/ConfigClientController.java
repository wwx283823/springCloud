package com.wj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${wj.name}")
    private String name;
    @Value("${wj.age}")
    private String age;
    @RequestMapping("/getConfigParam")
    public String showConfig(){
        return "姓名:"+name+",年龄:"+age;
    }
}
