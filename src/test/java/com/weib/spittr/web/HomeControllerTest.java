package com.weib.spittr.web;

//import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        
        /**
         * 手动添加以下依赖关系         
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.0.1</version>
        </dependency>
         */
        

/**
 *
 * @author zhangjingwei
 */
public class HomeControllerTest {
    
    @Test
    public void testGetHomePage() throws Exception{
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        
//        assertEquals("home", controller.home());
        mockMvc.perform(get("/"))       //对 "/" 执行GET请求
                .andExpect(view().name("home"));
        mockMvc.perform(get("/homepage"))       //对 "/homepage" 执行GET请求
                .andExpect(view().name("home"));
    }
    
    @Test
    public void testPostHomePage() throws Exception{
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        
        mockMvc.perform(post("/"))
                .andExpect(view().name("home"));
    }
}
