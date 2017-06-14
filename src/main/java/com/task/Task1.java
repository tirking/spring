package com.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.text.DateFormatter;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task1 {

	@Scheduled(cron = "0 44,45 * * * *")
	public void run() {
		try {
			String ss = null;
			ss.substring(0);
			System.out.println(this.getClass().getSimpleName() + " start "
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
			Thread.sleep(2000);
			System.out.println(this.getClass().getSimpleName() + " end "
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
		} catch (Exception e) {
			System.out.println("error:" + e.getMessage());
		}
	}
}