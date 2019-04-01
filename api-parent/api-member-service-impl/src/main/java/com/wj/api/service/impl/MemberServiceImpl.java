package com.wj.api.service.impl;

import com.wj.api.service.IMemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl implements IMemberService {
    @Value("${server.port}")
    private String port;
    @RequestMapping("/getMember")
    public String getMember(@RequestParam("name") String name) {
        try{
            Thread.sleep(3000);
        }catch (Exception e){

        }

        return "我是getMember实现"+name;
    }

    @RequestMapping("/getMember2")
    public String getMember2(@RequestParam("name") String name) {
        return "我是getMember实现"+name+",port:"+port;
    }

    @Override
    public String getMemberHystrix(String name) {
        try{
            Thread.sleep(1500);
        }catch (Exception e){

        }
        return "getMemberHystrix"+name+",port:"+port;
    }
}
