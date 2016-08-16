/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.spittr.repostory;

import com.weib.spittr.repostory.data.Spitter;

/**
 *
 * @author zhangjingwei
 */
public interface SpitterRepository {
    
    public Spitter save(Spitter spitter);
    
    public Spitter findByUsername(String username);
    
}
