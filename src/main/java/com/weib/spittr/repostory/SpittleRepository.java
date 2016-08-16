/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weib.spittr.repostory;

import com.weib.spittr.repostory.data.Spittle;
import java.util.List;

/**
 *
 * @author zhangjingwei
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    
    Spittle findOne(long id);
}
