package top.inson.springboot.service;

import java.util.Map;

/**
 * @ClassName IHandlerService
 * @Description 业务处理接口标准
 * @Author jingjitree
 * @Date 2020/9/27 17:10
 * @Version 1.0
 **/
public interface IHandlerService {

    void handler(Map<String, Object> params);

}
