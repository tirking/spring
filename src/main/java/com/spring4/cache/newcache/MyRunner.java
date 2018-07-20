package com.spring4.cache.newcache;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

	private MyAccountService accountService;

	public MyRunner(MyAccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.getValue("account1"); // 走数据库
		accountService.getValue("account1"); // 走缓存

		accountService.getValue("account1"); // 走缓存
		accountService.getValue("account1"); // 走缓存

		System.out.println("start testing clear cache..."); // 更新某个记录的缓存，首先构造两个账号记录，然后记录到缓存中
		Account account1 = accountService.getValue("somebody1");
		Account account2 = accountService.getValue("somebody2");
		// 开始更新其中一个
		account1.setId(1212);
		accountService.updateAccount(account1); // 使用了cachePut后，更新后，会被自动放到缓存中，所以后面查询仍会走查询。

		accountService.getValue("somebody1");// 因为被更新了，所以会查询数据库
		accountService.getValue("somebody2");// 没有更新过，应该走缓存
		accountService.getValue("somebody1");// 再次查询，应该走缓存 // 更新所有缓存

		accountService.reload();

		accountService.getValue("somebody1");// 应该会查询数据库
		accountService.getValue("somebody2");// 应该会查询数据库
		accountService.getValue("somebody1");// 应该走缓存
		accountService.getValue("somebody2");// 应该走缓存

	}

}
