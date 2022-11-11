package io.github.guanxin.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.github.guanxin.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    protected final Logger logger = LoggerFactory.getLogger(TestService.class);


    @DubboReference
    private DemoService demoService;
    @HystrixCommand(fallbackMethod = "reliable")
    public void test(String name) {
        logger.info("say hello {}", demoService.sayHello(name));
    }

    public String reliable(String name) {
        return "hystrix fallback value";
    }
}
