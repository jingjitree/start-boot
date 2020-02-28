package top.inson.springboot.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "users")
public class Users extends BaseEntity<Users> implements java.io.Serializable{

    private String username;
    private String account;
    private String password;
    private String phone;
    private Integer sex;
    private String idCard;
    private String address;

}
