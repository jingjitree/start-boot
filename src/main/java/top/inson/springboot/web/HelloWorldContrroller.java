package top.inson.springboot.web;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "你好世界")
@RestController
@RequestMapping(value = "/helloWorld")
public class HelloWorldContrroller {

    @ApiOperation(value = "欢迎接口")
    @GetMapping("/hello")
    public String hello(){
        return "hello world！你好世界！";
    }



}
