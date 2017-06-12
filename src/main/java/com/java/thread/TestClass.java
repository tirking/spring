package com.java.thread;

public class TestClass {

	private Test test = new Test("hehe");

	public static void main(String[] args) {
		TestClass t = new TestClass();
		t.test = new Test("haha");
		System.out.println(t.test.name);
	}
}

class Test {
	String name;

	public Test(String name) {
		this.name = name;
	}
}
