/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codekul.othergradle;

import com.codekul.othergradle.exception.Car;
import com.codekul.othergradle.exception.MyException;
import com.codekul.othergradle.generics.Generics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.Mac;

/**
 *
 * @author aniruddha
 */
public class Java {

    public static void main(String[] args) /*throws Exception*/ {

        setCollection();
    }

    public static void exceptionHandling() throws MyException {

        Car car = new Car();
        car.deviate(10);
        car.deviate(20);
        car.deviate(0);
        car.deviate(100);

        try {
            car.deviate(123d);
        } catch (Exception e) {
            System.out.println("" + e);
        }


        /*try {
            car.deviate(123d);
        } catch (Exception ex) {
            Logger.getLogger(Java.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public static void generics() {

        Generics<String> genString = new Generics<>();
        String str = genString.getObj();
        genString.setObj("131");

        Generics<Integer> genInt = new Generics<>();
        Integer intObj = genInt.getObj();
        genInt.setObj(50);

        Generics<Car> carGen = new Generics<>();
        Car car = carGen.getObj();
        carGen.setObj(new Car());
    }

    public static void collections() throws Exception {

        Collection<String> collStr = new ArrayList<>();

        collStr.add("India");
        collStr.add("China");
        collStr.add("Japan");
        collStr.add("Shri Lanka");

        collStr.remove("China");

        Iterator<String> itStr = collStr.iterator();
        while (itStr.hasNext()) {
            String element = itStr.next();
            System.out.println("" + element);
        }

        for (String str : collStr) { // foreach
            System.out.println(" foreach " + str);
        }
    }

    public static void listCollection() {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(10);
        list.add(null);
        list.add(20);
        list.add(30);
        list.add(40);

        for (Integer num : list) {
            System.out.println("" + num);
        }

        list.get(3);

        LinkedList<Car> listCars = new LinkedList<>();
        listCars.add(new Car());
        listCars.add(new Car());

        for (Car car : listCars) {

        }
    }

    public static void setCollection() {

        Set<Double> setDouble = new HashSet<>(10);
        setDouble.add(10d);
        setDouble.add(50.4d);
        setDouble.add(50.4d);
        setDouble.add(null);
        setDouble.add(null);

        for (Double d : setDouble) {
            System.out.println("" + d);
        }
    }

    public static void map() {

        Map<Integer, String> map = new HashMap<>();
        map.put(10, "android");
        map.put(11, "android");
        map.put(12, "ios");
        map.put(13, "RIM");
        map.put(14, "Symbian");
        map.put(null, null);

        Set<Integer> setKeys = map.keySet();
        for (Integer key : setKeys) {
            System.out.println("Key - " + key);
        }

        Collection<String> collection = map.values();
        for (String val : collection) {
            System.out.println("" + val);
        }
    }
}
