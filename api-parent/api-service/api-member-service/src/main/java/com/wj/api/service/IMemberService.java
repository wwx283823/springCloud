package com.wj.api.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IMemberService {

    @RequestMapping("/getMember")
    String  getMember(@RequestParam("name") String name);

    @RequestMapping("/getMember2")
    String  getMember2(@RequestParam("name") String name);

    @RequestMapping("/getMemberHystrix")
    String  getMemberHystrix(@RequestParam("name") String name);
}
