package top.inson.springboot.service;

public interface IStrategyService {

    /**
     * @Desctription 根据来源返回对应的实现类
     * @param strategyType
     * @return
     */
    IHandlerService getHandlerService(String strategyType);

}
