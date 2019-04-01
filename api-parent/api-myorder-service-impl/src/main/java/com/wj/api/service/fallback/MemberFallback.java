package com.wj.api.service.fallback;

import com.wj.api.service.feign.MemberFeignServer;
import org.springframework.stereotype.Component;

@Component
public class MemberFallback implements MemberFeignServer {

    @Override
    public String getMember(String name) {
        return "系统忙，请稍后再试！，以类的方式返回";
    }

    @Override
    public String getMember2(String name) {
        return "系统忙，请稍后再试！，以类的方式返回";
    }

    @Override
    public String getMemberHystrix(String name) {
        return "系统忙，请稍后再试！，以类的方式返回";
    }
}
