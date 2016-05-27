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
public class Car {

    // 20 years of java(8), it just begining ....
    private Integer speed = 10; // int speed;

    public void deviate(int angle) {

        //speed = angle; // autoboxing 
        speed = speed / angle;  // throw new ArtithmaticException();
        System.out.println("Speed is - " + speed);
    }

    public void deviate(double angle) throws MyException {

        /*try {
            if(angle > 100) throw new MyException();
        } catch (Exception e) {
            System.out.println("Exception occured, but dont worry I handled :)");
        }*/
        if (angle > 100) {
            throw new MyException();
        }

        System.out.println("Angle is " + angle);
    }
}
