/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.othergradle.exception;

/**
 *
 * @author aniruddha
 */
public class MyException extends /*Exception // checked exceptions*/ RuntimeException /*//unchecked exceptions*/{

    @Override
    public String getMessage() {
        return "Given anglel is out of scope"; 
    }
    /*
        if your class is extending to Exception or it children
    (not in the family of RuntimeException) then it becomes checked exception
    */
}
