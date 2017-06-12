package com.thinking.in.java.chapter4;

public class Chapter4 {

	// public Chapter4() {
	// System.out.println("empty constructor");
	// }

	public Chapter4(int i) {
		System.out.println("param constructor");
	}

	public static void main(String[] args) {
		// 测试构造器
		Chapter4 chapter4 = new Chapter4(4);
	}

	public String test() {
		return "test return type";
	}

	// public void test(){
	//
	// }

	public void test(int i, String j) {
		System.out.println("test void type");
	}

	public void test(String j, int i) {

	}
}
