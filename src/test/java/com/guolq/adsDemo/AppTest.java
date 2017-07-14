package com.guolq.adsDemo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	
	private Logger logger = LoggerFactory.getLogger(AppTest.class);
	
	
	@Test
	public void test() throws InterruptedException {
		
		while(true) {
			logger.info("i am a log : " + System.currentTimeMillis());
			Thread.sleep(100);
		}
		
	}
	
//	@Test
//	public void testSSH() throws IOException {
//		Shell shell = new SSHByPassword("111.231.0.86", 22, "ubuntu", "LiqingGuo@2014");
//		String stdout = new Shell.Plain(shell).exec("tail -f /home/ubuntu/server/apache-tomcat-8.5.15/logs/localhost_access_log.2017-07-07.txt");
//		logger.info(stdout);
//	}

}
