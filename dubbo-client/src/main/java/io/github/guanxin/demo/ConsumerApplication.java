/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.guanxin.demo;

import com.xiaomi.mifi.datamap.common.model.ResultDTO;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableHystrix
@EnableDubbo
public class ConsumerApplication {

    protected final Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);

        new ConsumerApplication().run(context, args);

        context.close();
    }

    private void run(ConfigurableApplicationContext context, String[] args) {
        DorisService dorisService = context.getBean(DorisService.class);
        ResultDTO<Boolean> resultDTO = dorisService.syncTableFields(args[0], args[1]);
        logger.info("result {}", resultDTO);

        TestService testService = context.getBean(TestService.class);
        testService.test("test");

    }
}
