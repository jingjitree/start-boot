package top.inson.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/view")
public class ViewFwdController {

    @GetMapping("/{url}")
    public String url(@PathVariable String url){
        return url;
    }

    @GetMapping("/{dir}/{url}")
    public String url2(@PathVariable String dir, @PathVariable String url){
        return dir + "/" + url;
    }

    @GetMapping("/{dir}/{dir2}/{url}")
    public String url3(@PathVariable String dir, @PathVariable String dir2, @PathVariable String url){
        return dir + "/" + dir2 + "/" + url;
    }

}
