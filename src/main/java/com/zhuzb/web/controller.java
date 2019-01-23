package com.zhuzb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by root on 2019/1/14.
 */
@Controller
public class controller {

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
