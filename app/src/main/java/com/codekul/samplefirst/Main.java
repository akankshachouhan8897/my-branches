package com.codekul.samplefirst;

/**
 * Created by aniruddha on 1/6/16.
 */
public class Main {

    public static void main(String[] args) {

        Outer outerObj = new Outer();

        Outer.NonStaticInner notStaticinner
                = outerObj.new NonStaticInner();

        Outer.StaticInner staticInner
                = new Outer.StaticInner();

        Edible edible = new Edible() { // anonymus
            @Override
            public void eat() {

            }
        };
        edible.eat();;

        MyEdible myEdible = new MyEdible();
        myEdible.eat();
    }

    private static class MyEdible implements Edible {
        @Override
        public void eat() {

        }
    }
}
