/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author zhangjingwei
 */
@Configuration
@ComponentScan(basePackages={"com.weib.spittr"},    //扫描所有非Web的Bean
        excludeFilters={
            @Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)   //过滤掉被Annotation（注释）为@EnableWebMvc的Bean
        })
public class RootConfig {
    
}
