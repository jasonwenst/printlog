package com.guolq.printlog.thread;

import java.io.IOException;
import java.io.Serializable;

import com.guolq.printlog.utils.FileUtils;


/**
 * @author guolq
 * @version 创建时间：2017年7月7日 下午1:21:15 类说明
 */
public class PrintThread extends Thread {
	
	volatile boolean stop = false;

	public void run() {
		while (!stop) {
			try {
				Thread.sleep(10);
				FileUtils.printLog();
			} catch (InterruptedException | IOException  e) {
				System.out.println("week up from blcok...");
				stop = true; // 在异常处理代码中修改共享变量的状态
			}
		}
		System.out.println(getName() + " is exiting...");
	}



//	public static void main(String[] args) throws InterruptedException {
//		MyThread m1 = new MyThread();
//		System.out.println("Starting thread...");
//		m1.start();
//		Thread.sleep(3000);
//		System.out.println("Interrupt thread...: " + m1.getName());
////		m1.stop = true; // 设置共享变量为true
//		m1.interrupt(); // 阻塞时退出阻塞状态
//		Thread.sleep(30000); // 主线程休眠3秒以便观察线程m1的中断情况
//		System.out.println("Stopping application...");
//	}

}

