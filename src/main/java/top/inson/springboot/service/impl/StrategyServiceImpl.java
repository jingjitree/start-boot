package top.inson.springboot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.inson.springboot.core.annoation.StrategyHandler;
import top.inson.springboot.service.IHandlerService;
import top.inson.springboot.service.IStrategyService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName HandlerConfiguration
 * @Description
 * @Author jingjitree
 * @Date 2020/9/27 17:17
 * @Version 1.0
 **/
@Slf4j
@Service
public class StrategyServiceImpl implements IStrategyService {
    private Map<String, IHandlerService> handlerMap;

    @Autowired
    public void setHandlerMap(List<IHandlerService> handlerServices){
        handlerMap = handlerServices.stream().collect(
                Collectors.toMap(
                        orderHandler ->
            AnnotationUtils.findAnnotation(orderHandler.getClass(), StrategyHandler.class).source(), v -> v, (v1, v2) -> v1
                )
        );
    }

    @Override
    public IHandlerService getHandlerService(String strategyType){
        if(StringUtils.isEmpty(strategyType) || !handlerMap.containsKey(strategyType))
            return null;
        return handlerMap.get(strategyType);
    }


}
