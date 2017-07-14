package com.guolq.printlog.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author guolq
 * @version 创建时间：2017年7月5日 下午9:18:03 类说明
 */
public class FileUtils {

	// 读取指定路径文本文件
	public static String read(String filePath) {
		StringBuilder str = new StringBuilder();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filePath));
			String s;
			try {
				while ((s = in.readLine()) != null)
					str.append(s + '\n');
			} finally {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str.toString();
	}

	// 写入指定的文本文件，append为true表示追加，false表示重头开始写，
	// text是要写入的文本字符串，text为null时直接返回
	public static void write(String filePath, boolean append, String text) {
		if (text == null)
			return;
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath, append));
			try {
				out.write(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printLog() throws IOException {
		String srcFilename = "C:\\Users\\Administrator.HAIER-PC\\Desktop\\log\\log.log";
		String charset = "GBK";
		InputStream fileInputStream = new FileInputStream(srcFilename);
		fileInputStream.skip(fileInputStream.available()); // skip n bytes
		Reader fileReader = new InputStreamReader(fileInputStream, charset);
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String singleLine;
		while (true) {
			if ((singleLine = bufferedReader.readLine()) != null) {
				System.out.println(singleLine);
				continue;
			}
		}
	}

	public static void printRemoteFile() throws IOException {
		URL urlfile = new URL("ftp://ubuntu:LiqingGuo@2014@111.231.0.86/shark.sql");
		BufferedReader in = new BufferedReader(new InputStreamReader(urlfile.openStream()));
		String content = "";
		String inputLine = in.readLine();
		while (inputLine != null) {
			content += inputLine;
			inputLine = in.readLine();
		}
		System.out.println(content);
		in.close();
	}


	public static void main(String a[]) throws IOException {
		printLog();
	}
}
