/**
 * @program: yeb
 * @description: 测试
 * @author nnnNN
 * @date 2021-04-04 23:47:43
 */

package com.hk01.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
    @GetMapping(value = "/employee/basic/hello")
    public String hello2(){
        return "/employee/basic/hello";
    }

    @GetMapping(value = "/employee/advanced/hello")
    public String hello3(){
        return "/employee/advanced/hello";
    }
}
