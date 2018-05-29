package io.github.biezhi.java8.stream;

import java.util.stream.IntStream;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/5/26 12:09
 */
public class MinDemo {
    public static void main(String[] args) {
        int[] nums = {33,55,-55,90,-666,90};
        int result = IntStream.of(nums).parallel().min().getAsInt();
        System.out.println("result = " + result);
    }
}