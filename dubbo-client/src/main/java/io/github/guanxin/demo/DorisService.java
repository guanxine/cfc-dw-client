package io.github.guanxin.demo;

import com.xiaomi.mifi.datamap.common.model.ResultDTO;
import com.xiaomi.mifi.datamap.scheduler.DorisLoadScheduleService;
import io.github.guanxin.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DorisService {

    protected final Logger logger = LoggerFactory.getLogger(DorisService.class);
    @DubboReference
    private DorisLoadScheduleService dorisLoadScheduleService;

    @DubboReference
    private DemoService demoService;

    public ResultDTO<Boolean> syncTableFields(String name, String code) {

        logger.info("check doris table table {}, tenantCode {}", name, code);
        return dorisLoadScheduleService.checkDorisTable(name, code);
    }



}
