package com.thinking.in.java;

class Number {
	int i;
}

public class Chapter3 {

	public static void main(String[] args) {
		Number n1 = new Number();
		Number n2 = new Number();
		n1.i = 9;
		n2.i = 27;
		System.out.println("初始化：n1.i=" + n1.i + ",n2.i=" + n2.i);

		// 对象赋值 n1/n2都指向了n2创建的对象
		n1 = n2;
		System.out.println("重新赋值后：n1.i=" + n1.i + ",n2.i=" + n2.i);

		n1.i = 47;
		System.out.println("变更n1后：n1.i=" + n1.i + ",n2.i=" + n2.i);

		n2.i = 55;
		System.out.println("变更n2后：n1.i=" + n1.i + ",n2.i=" + n2.i);

	}
}
