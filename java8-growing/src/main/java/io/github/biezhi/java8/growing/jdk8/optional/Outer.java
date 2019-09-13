package io.github.biezhi.java8.growing.jdk8.optional;

public class Outer {
    Nested nested = new Nested();
    Nested getNested(){
        return nested;
    }
}

class Nested{
    Inner inner = new Inner();
    Inner getInner(){
        return inner;
    }
}
class Inner{
    String foo;
//            = new String("Inner");
    String getFoo(){
        return foo;
    }
}
