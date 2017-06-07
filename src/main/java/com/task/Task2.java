package com.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 测试目的是：查看自动化任务，0,2,4 如果上个任务还未结束时，但又到了下一个任务开始时间，任务是否会起来
 * 输出结果：
 * Task2 start 2017-06-02 11:29:00 
 * Task2 end 2017-06-02 11:29:03
 * Task2 start 2017-06-02 11:29:04
 * Task2 end 2017-06-02 11:29:07
 * 
 * @author shengqy
 *
 */
@Component
public class Task2 {

	@Scheduled(cron = "0,2,4,6 * * * * *")
	public void run() {
		try {
			System.out.println(this.getClass().getSimpleName() + " start "
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
			Thread.sleep(3000);
			System.out.println(this.getClass().getSimpleName() + " end "
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}