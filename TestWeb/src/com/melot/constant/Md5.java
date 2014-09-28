package com.melot.constant;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import java.security.MessageDigest;

public class Md5 {

		/*
		 * 1.�?��运用基本类的实例 MessageDigest 对象�?��被初始化。该对象通过使用 update 方法处理数据�?任何时�?都可以调�?
		 * reset 方法重置摘要�?�?���?���?��更新的数据都已经被更新了，应该调�?digest 方法之一完成哈希计算�?
		 * 对于给定数量的更新数据，digest 方法只能被调用一次�? 在调�?digest 之后，MessageDigest
		 * 对象被重新设置成其初始状态�?
		 */
		public void encrypByMd5(String context) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(context.getBytes());// update处理
				byte[] encryContext = md.digest();// 调用该方法完成计�?

				int i;
				StringBuffer buf = new StringBuffer("");
				for (int offset = 0; offset < encryContext.length; offset++) {// 做相应的转化（十六进制）
					i = encryContext[offset];
					if (i < 0)
						i += 256;
					if (i < 16)
						buf.append("0");
					buf.append(Integer.toHexString(i));
				}
				System.out.println("32result: " + buf.toString());// 32位的加密
				System.out.println("16result: "
						+ buf.toString().substring(8, 24));// 16位的加密
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		 * 2.使用�?��的jar直接应用 使用外部的jar包中的类：import
		 * org.apache.commons.codec.digest.DigestUtils; 对上面内容的�?��封装使用方便
		 */
		public void encrypByMd5Jar(String context) {
			String md5Str = DigestUtils.md5Hex(context);
			System.out.println("32result:1 " + md5Str);
		}


	public static void main(String[] args) {
		Md5 md5 = new Md5();
		md5.encrypByMd5("yang");
		md5.encrypByMd5Jar("yang");
		
		System.out.println("32result1: " + md5);
	}
}
