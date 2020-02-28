package top.inson.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import top.inson.springboot.dao.IUsersMapper;
import top.inson.springboot.entity.Users;


@Log4j2
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {
    @Autowired
    private DruidDataSource druidDataSource;
    @Autowired
    private IUsersMapper usersMapper;


    @Test
    public void testDataSource(){
        log.info("druid数据源："+druidDataSource);

    }

    @Test
    public void testUsers(){
        Users users = usersMapper.selectById(1);
        log.info("查询用户：{}",users);
    }

}

