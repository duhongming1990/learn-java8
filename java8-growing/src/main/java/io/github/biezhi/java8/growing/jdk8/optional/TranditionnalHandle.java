package io.github.biezhi.java8.growing.jdk8.optional;

public class TranditionnalHandle {
    public static void main(String[] args) {
        Outer outer = new Outer();
        if(outer!=null
                && outer.nested!=null
                && outer.nested.inner!=null
                && outer.nested.inner.getFoo()!=null){
            System.out.println(outer.nested.inner.getFoo());
        }
    }
}
