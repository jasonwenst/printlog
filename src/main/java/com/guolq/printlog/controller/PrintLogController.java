package com.guolq.printlog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.util.Maps;
import com.guolq.printlog.thread.PrintThread;

/**
* @author guolq
* @version 创建时间：2017年7月7日 下午2:17:04
* 类说明
*/
@RestController
@RequestMapping("/printLog")
public class PrintLogController {
	
	private static Map<String, PrintThread> cacheThread = new HashMap<String, PrintThread>();
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping(value  ="/start", method = RequestMethod.GET)
	public void startPrint(String accountId) {
		PrintThread thread = new PrintThread();
		thread.start();
//		redisTemplate.opsForValue().set(accountId, thread);
		cacheThread.put(accountId, thread);
		System.out.println("current Thraed  = {}" + thread.hashCode());
	}
	
	@RequestMapping(value = "/stop", method = RequestMethod.GET)
	public void stopPrint(String accountId) {
		
//		PrintThread thread = (PrintThread) redisTemplate.opsForValue().get(accountId);
		PrintThread thread = cacheThread.get(accountId);
		System.out.println("current Thraed  = {}" + thread.hashCode());
		if(thread != null) {
			thread.interrupt();
			redisTemplate.delete(accountId);
		}
		
	}

}
