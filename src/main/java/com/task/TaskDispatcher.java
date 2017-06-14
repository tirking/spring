package com.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@SpringBootApplication
@EnableScheduling
public class TaskDispatcher {

	public static void main(String[] args) throws Exception {
		URL url = Thread.currentThread().getContextClassLoader().getResource("");
		File f = new File(url.getFile());
		String confPath = f.getParent();
		confPath = confPath.replaceAll("file:", "");
		System.setProperty("confLocation", confPath);

		// 加载scheduled.properties
//		Properties scheduledProp = new Properties();
//		scheduledProp.load(new InputStreamReader(new FileInputStream(confPath + "/conf/scheduled.properties"),
//				Charset.forName("utf-8")));

		SpringApplication app = new SpringApplication(TaskDispatcher.class);
//		app.setDefaultProperties(scheduledProp);
		app.run(args);
	}

	@Bean
	public TaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(5);
		return taskScheduler;
	}
}
