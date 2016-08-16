/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.spittr.repostory;

import com.weib.spittr.repostory.data.Spittle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import org.springframework.stereotype.Repository;
//import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangjingwei
 */
@Component
//@Repository
//@Profile("mock")
public class MockSpittleRepository implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList();
        for(int i = 0; i < count; i++){
            spittles.add(new Spittle("Spittle--" + (i + 1), new Date()));
        }
        
        return spittles;
    }

    @Override
    public Spittle findOne(long id) {
        return new Spittle("Spittle-" + id, new Date());
    }
    
}
