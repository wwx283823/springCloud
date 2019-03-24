package com.wj.api.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IOrderService {

    @RequestMapping("/getOrderToMember")
    String getOrderToMember(@RequestParam("name") String name);
}
