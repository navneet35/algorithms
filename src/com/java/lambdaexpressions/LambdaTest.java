package com.java.lambdaexpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		values.forEach(new Consumer<Integer>(){
			public void accept(Integer val){
				System.out.print(val + ", ");
			}
		});
		
		System.out.println();
		values.forEach(val -> System.out.print(val + ", "));
		System.out.println();		
		values.forEach(System.out::print);
	}

}
