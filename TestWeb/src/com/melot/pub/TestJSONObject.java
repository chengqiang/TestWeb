package com.melot.pub;

import org.json.JSONObject;

public class TestJSONObject {

	public static void main(String[] args) {
		String s = "{\"int\":1,\"bool\":true}";
		String jo = JSONObject.quote(s);
		jo.split("bool");
		System.out.println(jo);

	}
}
