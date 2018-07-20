package com.spring4.cache.nativ;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyCacheManager<T> {

	private Map<String, T> mapCache = new ConcurrentHashMap<String, T>();

	public T getValue(String name) {
		return mapCache.get(name);
	}

	public void addOrUpdateCache(String name, T value) {
		mapCache.put(name, value);
	}

	public void evictCache(String name) {
		if (mapCache.containsKey(name)) {
			mapCache.remove(name);
		}
	}

	public void evictCache() {
		mapCache.clear();
	}

}
