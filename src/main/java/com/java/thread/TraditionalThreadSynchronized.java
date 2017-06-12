package com.java.thread;

import org.springframework.util.StringUtils;

public class TraditionalThreadSynchronized {

	public static void main(String[] args) {
		// 结果“123987654321456789”
		new TraditionalThreadSynchronized().init();
	}

	private void init() {
		final Printer printer = new Printer();
		new Thread(new Runnable() {

			@Override
			public void run() {
				printer.print("123456789");
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				printer.print("987654321");

			}
		}).start();
	}

	// 内部类
	class Printer {
		public void print(String str) {
			if (StringUtils.isEmpty(str)) {
				return;
			}
			int len = str.length();
			for (int i = 0; i < len; i++) {
				System.out.print(str.charAt(i));
			}
			System.out.println();
		}
	}

}
