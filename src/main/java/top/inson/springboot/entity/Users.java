package top.inson.springboot.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName(value = "users")
public class Users extends BaseEntity<Users> implements java.io.Serializable{
    private static final long serialVersionUID = -5780832935531175109L;

    private String username;
    private String account;
    private String password;
    private String phone;
    private Integer sex;
    private String idCard;
    private String address;

}
