package com.spring4.cache.newcache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class MyAccountService {

	@Cacheable("accountCache") // 缓存名称叫accountCache,取key=入参的value
	public Account getValue(String name) {
		// 如果使用了 @Cacheable 注释，
		// 则当重复使用相同参数调用方法的时候，
		// 方法本身不会被调用执行，即方法本身被略过了，取而代之的是方法的结果直接从缓存中找到并返回了。
		// 方法内部实现不考虑缓存逻辑，直接实现业务
		Account account = getDBAccount(name);
		return account;
	}

	// @CacheEvict(value = "accountCache", key = "#account.getName()") // #
	// 是SpEL表达式，遍历方法的参数对象
	@CachePut(value = "accountCache", key = "#account.getName()") // cachePut确保方法被执行，同时方法的返回值也被记录到缓存中
	public void updateAccount(Account account) {
		updateDBAccount(account);
	}

	@CacheEvict(value = "accountCache", allEntries = true) // 清空 accountCache 缓存
	public void reload() {
		System.out.println("accountCache reload");
	}

	private void updateDBAccount(Account account) {
		System.out.println(" update db,account.name=" + account.getName());
	}

	private Account getDBAccount(String name) {
		System.out.println("get account from DB,name=" + name);
		return new Account(name);
	}

}
