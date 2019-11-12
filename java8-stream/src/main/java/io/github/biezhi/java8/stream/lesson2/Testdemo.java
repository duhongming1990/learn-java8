package io.github.biezhi.java8.stream.lesson2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/6/13 10:13
 */
public class Testdemo {
    public static void main(String[] args) throws IOException {
       Stream.iterate(0,n->n+2).limit(10).forEach(System.out::println);
    }
}