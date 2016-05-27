/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.othergradle.generics;

import com.codekul.othergradle.exception.Car;

/**
 *
 * @author aniruddha
 */
public class Generics<T/*T extends Car*/> {
    
    private Integer myInt;
    
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
