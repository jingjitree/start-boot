package top.inson.springboot;


import com.google.common.collect.Lists;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.List;

@Log4j2
public class TestLambda {

    @Test
    public void handler(){
        List<String> lists = Lists.newArrayList("a", "b", "c", "c", "d");
        log.info("lists:" + lists);
        long count = lists.stream().filter(val -> val.equals("c")).count();
        log.info(count);
        log.info("lists" + lists);

    }



}
