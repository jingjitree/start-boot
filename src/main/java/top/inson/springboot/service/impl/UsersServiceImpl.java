package top.inson.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.inson.springboot.dao.IUsersMapper;
import top.inson.springboot.entity.Users;
import top.inson.springboot.service.IUsersService;


@Service
public class UsersServiceImpl extends ServiceImpl<IUsersMapper, Users> implements IUsersService {


}
