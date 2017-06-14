package com.thinking.in.java.chapter4;

class Class1 {
	public Class1(int i) {
		System.out.println("class1:" + i);
	}
}

public class ConstructorSeqTest {

	private Class1 class1 = new Class1(1);
	private Class1 class2 = new Class1(2);

	public ConstructorSeqTest() {
		System.out.println("constructor test");
		class3 = new Class1(33);
	}

	private void f() {
		System.out.println("f()");
	}

	// 类内部变量定义的先后顺序决定初始化顺序，即使变量定义散布于方法定义之间，他们仍旧会在任何方法（包括构造方法）被调用之前得到初始化
	private Class1 class3 = new Class1(3);

	public static void main(String[] args) {
		ConstructorSeqTest test = new ConstructorSeqTest();
		test.f();
		// class1:1
		// class1:2
		// class1:3
		// constructor test
		// class1:33
		// f()
	}

}
