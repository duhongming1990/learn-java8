package io.github.biezhi.java8.stream.lesson2;

import io.github.biezhi.java8.stream.Project;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * 数值流
 * <p>
 * IntStream、DoubleStream、LongStream
 *
 * @author biezhi
 * @date 2018/2/12
 */
public class Example7 {

    public static void main(String[] args) {
        List<Project> projects = Project.buildData();
//        OptionalInt max = projects.stream()
//                .mapToInt(p -> p.getStars())
//                .max();
//        System.out.println(max.getAsInt());
        Map<String,List<Project>> map = projects.stream().parallel().collect(Collectors.groupingBy(Project::getLanguage));
        map.forEach((k,v)->{
            System.out.println(k);
            v.forEach(p->{
                System.out.println("p = " + p);
            });
        });
        for(int i=0;i<10000;i++){
            String threadName = Thread.currentThread().getName();
            System.out.println("threadName = " + threadName);
            Integer integer = projects.stream().parallel().collect(Collectors.summingInt(Project::getStars));
            System.out.println("integer = " + integer);
        }
    }

}