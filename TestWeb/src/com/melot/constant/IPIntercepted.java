package com.melot.constant;

import java.util.Random;

public class IPIntercepted {
	public static void main(String[] args) {
/*		String ip = "192.168.1.233";
		String i = "12";
		System.out.println(i.length());
		String newIp = ip.substring(0,
				ip.indexOf(".", ip.indexOf(".", ip.indexOf(".") + 1)));
		System.out.println(newIp);*/
		int number = new Random().nextInt(10) + 1;
		System.out.println(number+"sj");
		String ipB="59.64.159.224";  
		String ipE="50.64.159.224";  
		String ip="10.0.0.63";
		
	    String[] strarray=ip.split("\\.");
	    System.out.println(strarray[2]+"length"+strarray[1].length());
	    if (strarray[1].length()==1 ) {
	    	String a="00"+strarray[1];
			System.out.println(strarray[1]+"strarray[1]"+a);
		}else{
			String a="0"+strarray[1];
			System.out.println(strarray[1]+"strarray[1]"+a);
		}
	    if(strarray[2].length()==1){
	    	String b="00"+strarray[2];
	    	System.out.println(strarray[2]+"strarray[1]"+b);
	    }else{
	    	String b="0"+strarray[2];
	    	System.out.println(strarray[2]+"strarray[1]"+b);
	    }
	    if(strarray[3].length()==1){
	    	String c="00"+strarray[3];
	    	System.out.println(strarray[3]+"strarray[1]"+c);
	    }else{
	    	String c="0"+strarray[3];
	    	System.out.println(strarray[3]+"strarray[1]"+c);
	    	
	    }
		String ipBeginry[]=ipB.split("\\.",0); 
		String ipendry[]=ipE.split("\\.",1); 
		//TODO
		for(String ipbegins:ipBeginry){  
			System.out.print("  "+ipbegins+" =");
		}  
		for(String ipends:ipendry){  
			System.out.print(ipends+"====");
		}  
		
	 System.out.println(strarray[0]);
	}
}
