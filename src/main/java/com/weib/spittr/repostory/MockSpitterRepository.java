/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.spittr.repostory;

import com.weib.spittr.repostory.data.Spitter;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangjingwei
 */
@Component
public class MockSpitterRepository implements SpitterRepository {

    @Override
    public Spitter save(Spitter spitter) {
        return new Spitter(24L, spitter.getFirstName(), spitter.getLastName(), spitter.getUsername(), spitter.getPassword());
    }

    @Override
    public Spitter findByUsername(String username) {
        return new Spitter(24L, "zhang", "jingwei", username, "19841021");
    }
    
}
