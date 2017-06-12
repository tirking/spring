package com.java.thread;

import java.util.Random;

// 外部类，如果这个类是个内部类，则完全不同
class Value {
	int i; // package access

	public Value(int i) {
		this.i = i;
	}
}

public class TestFinal {

	private static Random rand = new Random();
	private String id;

	// can be compile-time constants
	private final int VAL_ONE = 9;
	private static final int VAL_TWO = 99;
	// typical public constant
	public static final int VAL_THREE = 39;
	// cannot be compile-time constant
	private final int i4 = rand.nextInt(20);
	static final int i5 = rand.nextInt(20);
	private Value value1 = new Value(11);
	private final Value value2 = new Value(33);
	private Value value4 = null;
	// 注意Value是内部类时，这个声明编译通不过
	private static final Value v3 = new Value(33);

	// arrays
	private final int[] a = { 1, 2, 3, 4, 5, 6 };

	@Override
	public String toString() {
		return id + ":" + "i4=" + i4 + ",i5=" + i5;
	}

	public TestFinal(String id) {
		this.id = id;
	}

	public static void main(String[] args) {
		TestFinal tf1 = new TestFinal("testFinal1");
		// tf1.VAL_ONE++;tf1.VAL_TWO++;tf1.VAL_THREE++; Error:can't change value
		// reason:final基础类型，无论其他修饰符是什么，都是不可修改。
		// tf1.value1 = new Value(9);
		// Error:No enclosing instance of type TestFinal is accessible. Must
		// qualify the allocation with an enclosing instance of type TestFinal
		// (e.g. x.new A() where x is an instance of TestFinal).
		//
		tf1.value2.i++; // object isn't constant;
		tf1.value4 = new Value(19); // ok

	}

}
