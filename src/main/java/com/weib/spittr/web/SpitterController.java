/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.spittr.web;

import com.weib.spittr.repostory.SpitterRepository;
import com.weib.spittr.repostory.data.Spitter;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *
 * @author zhangjingwei
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {
    
    private final SpitterRepository repository;
    
    @Autowired
    public SpitterController(SpitterRepository repository){
        this.repository = repository;
    }
    
    @RequestMapping(value="/register", method=GET)
    public String showRegistForm(){
        return "spitter_register_form";
    }
    
    @RequestMapping(value="/register", method=POST)
    public String registProcess(@ModelAttribute("spitter") @Valid Spitter spitter,
            Errors errors, Model model){
        
        if(errors.hasErrors()){
            model.addAttribute("errors", errors.getAllErrors());
            return "spitter_register_form";
        }
        
        repository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }
    
    @RequestMapping(value="/{username}", method=GET)
    public String spitterInfo(@PathVariable String username, Model model){
        model.addAttribute("spitter", repository.findByUsername(username));
        return "spitter_info";
    }
}
