package com.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task1 {

	@Scheduled(cron = "0,3,6,9 * * * * *")
	public void run() {
		try {
			System.out.println(this.getClass().getSimpleName() + " start "
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
			Thread.sleep(2000);
			System.out.println(this.getClass().getSimpleName() + " end "
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}