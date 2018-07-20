package com.java.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.pub.DateFormater;

public class Awer {

	public static Map<String, String> pidMap = new HashMap<String, String>();
//	public static Map<String, String> pidMap = new ConcurrentHashMap<String, String>();

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();

		String pid1 = new String("pid1111111");
		String pid2 = new String("pid2222222");

		int i = 0;
		while (i < 5) {
			i++;
			service.submit(new TestTask("task-a-" + i, pid1));
		}

		i = 0;
		while (i < 5) {
			i++;
			service.submit(new TestTask("task-b-" + i, pid2));
		}

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// i = 10;
		// while (i < 15) {
		// i++;
		// service.submit(new TestTask("task-a-" + i, pid1));
		// }
		//
		// i = 10;
		// while (i < 15) {
		// i++;
		// service.submit(new TestTask("task-b-" + i, pid2));
		// }
	}
}

class TestTask implements Runnable {

	private String name;
	private String pid;

	public TestTask(String name, String pid) {
		this.name = name;
		this.pid = pid;
	}

	@Override
	public void run() {
		this.doTest(pid);

	}

	private void doTest(String pid) {
		synchronized (pid.intern()) {
			System.out.println(DateFormater.getInstance().getLongFormat() + this.name + "  synchronized");
			if (Awer.pidMap.get(pid) != null) {
				System.out.println(
						DateFormater.getInstance().getLongFormat() + " cannot join " + this.pid + "   " + this.name);
				return;
			}

			try {
				System.out.println(
						DateFormater.getInstance().getLongFormat() + " joining " + this.pid + "   " + this.name);
				TimeUnit.SECONDS.sleep(5);
				Awer.pidMap.put(pid, pid);
				System.err.println(
						DateFormater.getInstance().getLongFormat() + " joined " + this.pid + "   " + this.name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}