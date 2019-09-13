package io.github.biezhi.java8.growing.jdk8.optional;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalHandle {
    public static void main(String[] args) {

        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);

        resolve(()->new Outer().getNested().getInner().getFoo())
                .ifPresent(System.out::println);


    }
    public static <T> Optional<T> resolve(Supplier<T> resolver){
        try{
            T result = resolver.get();
            return Optional.ofNullable(result);
        }catch (NullPointerException e){
            return Optional.empty();
        }
    }
}
