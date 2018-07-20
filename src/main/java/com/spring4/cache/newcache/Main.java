package com.spring4.cache.newcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-cache/
 * 
 * @author shengqy
 *
 */
@SpringBootApplication
@EnableCaching
public class Main {

	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);

	}

}
