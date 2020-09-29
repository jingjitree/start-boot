package top.inson.springboot.core.annoation;


import java.lang.annotation.*;

/**
 * @ClassName IHandlerService
 * @Description 用来标识类来源
 * @Author jingjitree
 * @Date 2020/9/27 17:10
 * @Version 1.0
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StrategyHandler {

    String source();

}
