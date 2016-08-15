/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *
 * @author zhangjingwei
 */
@Controller //定义一个Controller
@RequestMapping({"/", "/homepage"}) //处理URI列表
public class HomeController {
    
    //@RequestMapping(value="/", method=GET)
    @RequestMapping(method=GET) //处理GET访问请求
    public String home(){
        return "home";
    }
    
    @RequestMapping(method=POST) //处理POST访问请求
    public String homecommit(){
        return "home";
    }
}
