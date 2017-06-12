package com.java.thread;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class CreateThread {

	public static void main(String[] args) {
		// 第一种继承类
		new Thread() {
			@Override
			public void run() {
				System.out.println("第一种创建线程：" + Thread.currentThread().getName());
			}
		}.start();

		// 第二种实现接口
		new Thread(new Runnable() {
			public void run() {
				System.out.println("第二种创建线程：" + Thread.currentThread().getName());
			}
		}).start();
	}
}
