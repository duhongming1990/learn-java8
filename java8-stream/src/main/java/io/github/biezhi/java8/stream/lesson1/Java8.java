package io.github.biezhi.java8.stream.lesson1;

import io.github.biezhi.java8.stream.Project;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author biezhi
 * @date 2018/2/11
 */
public class Java8 {

    public static void main(String[] args) {
        List<Project> projects = Project.buildData();
//        List<String> names = projects.stream()
//                .filter(p -> {
//                    System.out.println(p.getName());
//                    return p.getStars() > 1000;
//                })
//                .map(p -> {
//                    System.out.println(p.getName());
//                    return p.getName();
//                })
//                .limit(3)
//                .collect(Collectors.toList());
//        System.out.println(names);
//
//        names.stream().forEach(name-> System.out.println(name));

        Stream.iterate(0,n -> n+2).filter(integer -> integer % 10000==0).forEach(System.out::println);

    }

}
