/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.spittr.web;

import com.weib.spittr.repostory.SpittleRepository;
import com.weib.spittr.repostory.data.Spittle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 *
 * @author zhangjingwei
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    public SpittleRepository spittleRepository;
    
    @Autowired
    SpittleController(SpittleRepository spittleRepository) {    //自动加载Repository
        this.spittleRepository = spittleRepository;
    }
    
    @RequestMapping(method=GET)
    public String spittles(Model model){
        //model中实际为KEY-Value的Map，当不指定KEY时，会默认根据类型指定，比如List<Spittle> : spittleList
        model.addAttribute("spittleList11", this.spittleRepository.findSpittles(Long.MAX_VALUE, 20)); //向模型中加入数据
        return "spittles";
    }
    
    //该方法跟上面的方法相同，都是使用了默认的设定
    //视图名为: spittles
    //参数名为: spittleList
    @RequestMapping(method=POST)   
    public List<Spittle> spittles(){
        return this.spittleRepository.findSpittles(Long.MAX_VALUE, 20); //向模型中加入数据
    }
}
