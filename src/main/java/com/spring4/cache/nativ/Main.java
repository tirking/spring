package com.spring4.cache.nativ;

/**
 * https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-cache/
 * @author shengqy
 *
 */
public class Main {

	public static void main(String[] args) {

		MyAccountService accountService = new MyAccountService();

		accountService.getValue("account1"); // 走数据库
		accountService.getValue("account1"); // 走缓存

		accountService.reload(); // 重载缓存

		accountService.getValue("account1"); // 走数据库
		accountService.getValue("account1"); // 走缓存
		accountService.getValue("account1"); // 走缓存
	}

}
