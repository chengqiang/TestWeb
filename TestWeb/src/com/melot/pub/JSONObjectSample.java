package com.melot.pub;

import org.json.JSONException;


public class JSONObjectSample {

    // 创建JSONObject对象
    private static org.json.JSONObject createJSONObject() {
        org.json.JSONObject jsonObject = new org.json.JSONObject();
        try {
			jsonObject.put("name", "kevin");
			jsonObject.put("Max.score", new Integer(100));
			jsonObject.put("Min.score", new Integer(50));
			jsonObject.put("nickname", "picglet");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return jsonObject;
    }

    public static void main(String[] args) {
        JSONObjectSample sa = new JSONObjectSample();
        sa.createJSONObject();
    }

    /*
     * public static void main(String[] args) { JSONObject jsonObject = JSONObjectSample.createJSONObject(); //
     * 输出jsonobject对象 System.out.println("jsonObject==>" + jsonObject); // 判读输出对象的类型 boolean isArray =
     * jsonObject.isArray(); boolean isEmpty = jsonObject.isEmpty(); boolean isNullObject = jsonObject.isNullObject();
     * System.out.println("isArray:" + isArray + " isEmpty:" + isEmpty + " isNullObject:" + isNullObject); // 添加属性
     * jsonObject.element("address", "swap lake"); System.out.println("添加属性后的对象==>" + jsonObject); // 返回一个JSONArray对象
     * JSONArray jsonArray = new JSONArray(); jsonArray.add(0, "this is a jsonArray value"); jsonArray.add(1,
     * "another jsonArray value"); jsonObject.element("jsonArray", jsonArray); JSONArray array =
     * jsonObject.getJSONArray("jsonArray"); System.out.println("返回一个JSONArray对象：" + array); // 添加JSONArray后的值 //
     * {"name":"kevin","Max.score":100,"Min.score":50,"nickname":"picglet","address":"swap lake", //
     * "jsonArray":["this is a jsonArray value","another jsonArray value"]} System.out.println(jsonObject); //
     * 根据key返回一个字符串 String jsonString = jsonObject.getString("name"); System.out.println("jsonString==>" + jsonString);
     * }
     */
}
