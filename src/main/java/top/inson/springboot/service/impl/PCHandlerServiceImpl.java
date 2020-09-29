package top.inson.springboot.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import top.inson.springboot.core.annoation.StrategyHandler;
import top.inson.springboot.service.IHandlerService;

import java.util.Map;

/**
 * @ClassName PCHandlerServiceImpl
 * @Description 业务处理实现类
 * @Author jingjitree
 * @Date 2020/9/27 17:10
 * @Version 1.0
 **/
@Log4j2
@Service
@StrategyHandler(source = "pc")
public class PCHandlerServiceImpl implements IHandlerService {

    @Override
    public void handler(Map<String, Object> params) {
       log.info("处理pc请求的方法");

    }

}
