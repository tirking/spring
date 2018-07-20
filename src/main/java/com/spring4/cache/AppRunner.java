package com.spring4.cache;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

	private BookRespository bookRepository;

	public AppRunner(BookRespository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(".... Fetching books");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())
				+ " ID-1234 -->" + bookRepository.getBookByID("1234"));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())
				+ " ID-4567 -->" + bookRepository.getBookByID("4567"));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())
				+ " ID-1234 -->" + bookRepository.getBookByID("1234"));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())
				+ " ID-4567 -->" + bookRepository.getBookByID("4567"));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())
				+ " ID-1234 -->" + bookRepository.getBookByID("1234"));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())
				+ " ID-1234 -->" + bookRepository.getBookByID("1234"));

	}

}
