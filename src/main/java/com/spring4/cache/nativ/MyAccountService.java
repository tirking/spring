package com.spring4.cache.nativ;

public class MyAccountService {

	private MyCacheManager<Account> accountCache = new MyCacheManager<Account>();

	public Account getValue(String name) {
		Account account = accountCache.getValue(name);
		if (account != null) {
			System.out.println("get account from cache,name=" + name);
			return account;
		}

		account = getDBAccount(name);
		if (account != null) {
			accountCache.addOrUpdateCache(name, account);
		}

		return account;
	}

	private Account getDBAccount(String name) {
		System.out.println("get account from DB,name=" + name);
		return new Account(name);
	}

	public void reload() {
		accountCache.evictCache();
	}

}
