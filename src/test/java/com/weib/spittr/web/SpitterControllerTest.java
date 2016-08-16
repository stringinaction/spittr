/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.spittr.web;

import com.weib.spittr.repostory.SpitterRepository;
import com.weib.spittr.repostory.data.Spitter;
import org.junit.Test;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 *
 * @author zhangjingwei
 */
public class SpitterControllerTest {
    
    @Test
    public void showRegisterFormTest() throws Exception{
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("spitter_register_form"));
    }
    
    @Test
    public void processRegisterTest() throws Exception{
        Spitter unsave_spitter = new Spitter("zhang", "jingwei", "weib", "19841021");
        Spitter saved_spitter = new Spitter(24L, "zhang", "jingwei", "weib", "19841021");
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        when(mockRepository.save(unsave_spitter)).thenReturn(saved_spitter);
        
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        
        mockMvc.perform(post("/spitter/register")
                .param("firstName", "zhang")
                .param("lastName", "jingwei")
                .param("username", "weib")
                .param("password", "19841021"))
                .andExpect(redirectedUrl("/spitter/weib"));
        
        verify(mockRepository, atLeastOnce()).save(unsave_spitter);//不太明白含义(Spitter中的hashCode和equals是必须的)
    }
}
