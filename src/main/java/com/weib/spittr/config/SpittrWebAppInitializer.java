/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author zhangjingwei
 */
public class SpittrWebAppInitializer 
        extends AbstractAnnotationConfigDispatcherServletInitializer{   //WEB初始化，Spring能够自动加载继承了AbstractAnnotationConfigDispatcherServletInitializer类的子类

    @Override
    protected Class<?>[] getRootConfigClasses() {   //定义非Web配置类
        return new Class<?>[]{ RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {    //定义Web配置类
        return new Class<?>[]{ WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {   //将/映射到该DispatcherServlet 可以理解为RootPath为/
        return new String[]{ "/" };
    }
    
}
