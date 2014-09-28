package com.melot.constant;

import java.io.UnsupportedEncodingException;
/**
 * 
 * 类A.java的实现描述：TODO 类实现描�?
 * @author Administrator 2014�?�?8�?上午9:14:37
 */
public class UrlParameterTranscoding {
public static void main(String[] args) {
	
	try {
		String a =new String("æ­å·".getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(a);
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
