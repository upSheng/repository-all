package com.chs.dubbo.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/2 15:40
 */
@Slf4j
@Service
public class DubboConsumerService {

    @DubboReference(version = "1.0.0", group = "myTest")
    private DemoService demoService;

    public void say() {
        log.info("aa");
        log.info(demoService.sayHello("mercyblitz"));
    }

}
