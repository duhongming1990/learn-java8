package io.github.biezhi.java8.stream;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamDemo {
	
	public static void main(String args[]){
		
		long[] intArr = new long[1_0000_0000];
		for(long i=0;i<1_0000_0000;i++){
			intArr[(int) i]=i;
		}
		
		long before = System.currentTimeMillis();
		
//		long i = LongStream.of(intArr).max().getAsLong();
//		System.out.println(i);

		long result=0;
		for(long i=0;i<1_0000_0000;i++){
			if(result<i){
				result = i;
			}
		}
		System.out.println(result);

		long after = System.currentTimeMillis();
		
		System.out.println(after-before);
		
	}

}
