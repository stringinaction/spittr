/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.spittr.web;

import com.weib.spittr.repostory.data.Spittle;
import com.weib.spittr.repostory.SpittleRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.hamcrest.CoreMatchers.hasItems;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 *
 * @author zhangjingwei
 */
public class SpittleControllerTest {
    
    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittleList = new ArrayList();
        for(int i = 0; i < count; i++){
            spittleList.add(new Spittle("test---" + (i + 1), new Date()));
        }
        return spittleList;
    }    
    
    @Test
    public void getSpittleTest() throws Exception{
        //创建一个测试用的数据源
        List<Spittle> spittleList = createSpittleList(20);      //生成20条测试数据
        SpittleRepository mockRepository = mock(SpittleRepository.class);   //创建数据源的Mock实现
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20))       //当对接口进行调用时返回测试数据
                .thenReturn(spittleList);
        
        //创建测试用的controller
        SpittleController controller = new SpittleController(mockRepository);   //构建一个测试用的controller
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(
                new InternalResourceView("/WEB-INF/views/spittles.jsp") //视图名和请求路径相同，因此要调用setSingleView
        ).build();
        
        //发起GET的/spittles请求，并且断言
        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList11"))
                .andExpect(model().attribute("spittleList11", hasItems(spittleList.toArray())));
                
    }
    
    @Test
    public void postSpittleTest() throws Exception{
        //创建一个测试用的数据源
        List<Spittle> spittleList = createSpittleList(20);      //生成20条测试数据
        SpittleRepository mockRepository = mock(SpittleRepository.class);   //创建数据源的Mock实现
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20))       //当对接口进行调用时返回测试数据
                .thenReturn(spittleList);
        
        //创建测试用的controller
        SpittleController controller = new SpittleController(mockRepository);   //构建一个测试用的controller
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(
                new InternalResourceView("/WEB-INF/views/spittles.jsp") //视图名和请求路径相同，因此要调用setSingleView
        ).build();
        
        //发起GET的/spittles请求，并且断言
        mockMvc.perform(post("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(spittleList.toArray())));
                
    }
    
}
