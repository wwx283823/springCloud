package com.wj.api.service.feign;

import com.wj.api.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "member-client")
public interface OrderFeignServiceImpl extends IMemberService {
}
