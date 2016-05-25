/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.othergradle;

import com.codekul.othergradle.exception.Car;
import com.codekul.othergradle.exception.MyException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aniruddha
 */
public class Java {

    public static void main(String[] args) /*throws Exception*/ {

        try {
            exceptionHandling();
        } catch (IOException ex) {

        } catch (MyException ex) {

            System.out.println(""+ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(Java.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable t) {

        }

        System.out.println("Executed");
    }

    public static void exceptionHandling() throws Exception {

        Car car = new Car();
        car.deviate(10);
        car.deviate(20);
        car.deviate(012);
        car.deviate(100);

        car.deviate(123d);

        /*try {
            car.deviate(123d);
        } catch (Exception ex) {
            Logger.getLogger(Java.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
