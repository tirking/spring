package com.spring4.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class BookRespositoryImpl implements BookRespository {

	@Override
	@Cacheable("books")
	public Book getBookByID(String ID) {
		simulateSlowService();
		return new Book(ID, "some thing");
	}

	private void simulateSlowService() {

		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
