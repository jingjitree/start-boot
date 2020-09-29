package top.inson.springboot.web;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.inson.springboot.service.IHandlerService;
import top.inson.springboot.service.IStrategyService;

import java.util.Map;

/**
 * 策略模式测试控制器
 */
@RestController
@RequestMapping(value = "/strategy")
public class StrategyController {
    @Autowired
    private IStrategyService strategyService;



    @GetMapping("/test")
    public String test(@RequestParam String strategyType){
        Map<String, Object> params = Maps.newHashMap();
        IHandlerService handlerService = strategyService.getHandlerService(strategyType);
        handlerService.handler(params);
        return "success";
    }


}
