package com.wj.api.service.feign;

import com.wj.api.service.IMemberService;
import com.wj.api.service.fallback.MemberFallback;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "member-client",fallback = MemberFallback.class)
public interface MemberFeignServer extends IMemberService {
}
