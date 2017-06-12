package com.java.thread;

public class TestThread1 {

	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("第一个线程：" + Thread.currentThread().getName());
				}
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("第二个线程：" + Thread.currentThread().getName());
				}
			}
		}.start();

		System.out.println("main线程：" + Thread.currentThread().getName());
	}

}
