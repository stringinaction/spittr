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
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {
    
    //@RequestMapping(value="/", method=GET)
    @RequestMapping(method=GET)
    public String home(){
        return "home";
    }
    
    @RequestMapping(method=POST)
    public String homecommit(){
        return "home";
    }
}
