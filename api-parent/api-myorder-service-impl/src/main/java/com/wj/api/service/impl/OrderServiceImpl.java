package com.wj.api.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wj.api.service.IOrderService;
import com.wj.api.service.feign.MemberFeignServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl implements IOrderService {

    @Autowired
    MemberFeignServer orderFeignService;

//    @RequestMapping("/getOrderToMember")
//    public String getOrderToMember(@RequestParam("name")String name) {
//        User user = new User();
//        user.setName(name);
//        user.setAge(28);
//        return "getOrderToMember  "+name+",user:"+user.toString();
//    }

    @RequestMapping("/getOrderToMember")
    public String getOrderToMember(@RequestParam("name")String name) {

        return orderFeignService.getMember2(name)+Thread.currentThread().getName();
    }

    @RequestMapping("/getOrderToMember2")
    public String getOrderToMember2(@RequestParam("name")String name) {
        try{
//            Thread.sleep(2500);
        }catch (Exception e){

        }

        return orderFeignService.getMember(name);
    }


    @HystrixCommand(fallbackMethod = "getOrderToMemberFallback")//默认开启线程池隔离，降级，熔断
    @RequestMapping("/getOrderToMemberHystrix")
    public String getOrderToMemberHystrix(@RequestParam("name")String name) {

        return orderFeignService.getMemberHystrix(name)+Thread.currentThread().getName();
    }

    @RequestMapping("/getOrderToMemberHystrixByClass")
    public String getOrderToMemberHystrixByClass(@RequestParam("name")String name) {

        return orderFeignService.getMemberHystrix(name)+Thread.currentThread().getName();
    }

    @HystrixCommand(fallbackMethod = "getOrderToMemberFallback")//默认开启线程池隔离，降级，熔断
    @RequestMapping("/getOrderToMemberHystrix2")
    public String getOrderToMemberHystrix2(@RequestParam("name")String name) {

        return orderFeignService.getMember(name)+Thread.currentThread().getName();
    }

    public String getOrderToMemberFallback(String name){
        return "我是order，会员服务忙，请稍后访问"+name;
    }
}
