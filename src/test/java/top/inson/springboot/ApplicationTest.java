package top.inson.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Maps;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import top.inson.springboot.core.annoation.StrategyHandler;
import top.inson.springboot.dao.IUsersMapper;
import top.inson.springboot.entity.Users;
import top.inson.springboot.service.IHandlerService;

import java.util.Map;


@Log4j2
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {
    @Autowired
    private DruidDataSource druidDataSource;
    @Autowired
    private IUsersMapper usersMapper;
    @Autowired
    private ApplicationContext context;


    @Test
    public void testDataSource(){
        log.info("druid数据源："+druidDataSource);

    }

    @Test
    public void testUsers(){
        Users users = usersMapper.selectById(1);
        log.info("查询用户：{}",users);
    }

    @Test
    public void testAnnotationUtil(){
        Map<String, IHandlerService> handlerMap = Maps.newHashMap();

        Map<String, IHandlerService> strategyMaps = context.getBeansOfType(IHandlerService.class);
        log.info("strategyMaps:{}", strategyMaps);
        for (IHandlerService handler : strategyMaps.values()) {
            /*
            //第一种方式
            String source = AnnotationUtils.findAnnotation(handler.getClass(), StrategyHandler.class).source();
            if (!StringUtils.isEmpty(source))
                handlerMap.put(source, handler);
            */
            //第二种方式
            StrategyHandler annotation = handler.getClass().getAnnotation(StrategyHandler.class);
            if(annotation != null)
                handlerMap.put(annotation.source(), handler);

        }
        log.info("handlerMap:{}", handlerMap);

    }


}

