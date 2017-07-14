package com.guolq.printlog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.conf.ConfigurationLoadException;
import com.google.api.ads.common.lib.exception.OAuthException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.client.auth.oauth2.Credential;
import com.guolq.printlog.thread.PrintThread;

@RestController
@RequestMapping("/auth")
public class AuthController {
	

	
	public String auth(HttpServletRequest request) throws OAuthException, ValidationException, ConfigurationLoadException {
		Credential credential = new OfflineCredentials.Builder()
			      .forApi(OfflineCredentials.Api.ADWORDS)
			      .fromFile()
			      .build()
			      .generateCredential();
		
		
		return null;
	}
	
	
	public static void main(String a[]) throws InterruptedException {
		PrintThread thread = new PrintThread();
		thread.start();
		Thread.sleep(3000);
		System.out.println("Interrupt thread...: " + thread.getName());
//			thread.stop = true; // 设置共享变量为true
		thread.interrupt(); // 阻塞时退出阻塞状态
		Thread.sleep(3000); // 主线程休眠3秒以便观察线程m1的中断情况
		System.out.println("Stopping application...");
	}
}
