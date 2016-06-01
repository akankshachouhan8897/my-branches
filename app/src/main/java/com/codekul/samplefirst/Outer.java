package com.codekul.samplefirst;

/**
 * Created by aniruddha on 1/6/16.
 */
public class Outer {

    private int name;

    public class NonStaticInner {
        private String copy;

        public void innerMethod(){
            name = 10;
        }
    }

    public static class StaticInner {
    }

    public void myMethod(){
        final class LocalInner {

        }
        LocalInner local = new LocalInner();
    }
}
