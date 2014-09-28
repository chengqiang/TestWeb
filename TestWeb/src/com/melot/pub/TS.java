package com.melot.pub;

import org.json.JSONException;
import org.json.JSONObject;

public class TS {

    public JSONObject as() {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("a", 1);
            jsonObject.put("b", 1.1);
            jsonObject.put("c", 1L);
            jsonObject.put("d", "test");
            jsonObject.put("e", true);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(jsonObject);
        return jsonObject;
    }

    // {"d":"test","e":true,"b":1.1,"c":1,"a":1}

    /*
     * JSONObject jsonObject = new JSONObject(); jsonObject.put("a", 1); jsonObject.put("b", 1.1); jsonObject.put("c",
     * 1L); jsonObject.put("d", "test"); jsonObject.put("e", true); System.out.println(jsonObject);
     * //{"d":"test","e":true,"b":1.1,"c":1,"a":1} // 解析一个json对象(可以解析不同类型的数据)： jsonObject =
     * getJSONObject("{d:test,e:true,b:1.1,c:1,a:1}"); System.out.println(jsonObject);
     * //{"d":"test","e":true,"b":1.1,"c":1,"a":1} System.out.println(jsonObject.getInt("a"));
     * System.out.println(jsonObject.getDouble("b")); System.out.println(jsonObject.getLong("c"));
     * System.out.println(jsonObject.getString("d")); System.out.println(jsonObject.getBoolean("e")); jsonObject =
     * getJSONObject("{d:test,e:true,b:1.1,c:1,a:1}"); System.out.println(jsonObject);
     * //{"d":"test","e":true,"b":1.1,"c":1,"a":1} System.out.println(jsonObject.getInt("a"));
     * System.out.println(jsonObject.getDouble("b")); System.out.println(jsonObject.getLong("c"));
     * System.out.println(jsonObject.getString("d")); System.out.println(jsonObject.getBoolean("e"));
     * getJSONObject(String str)
     */

    /*
     * public static JSONObject getJSONObject(String str) { if (str == null || str.trim().length() == 0) return null;
     * JSONObject jsonObject = null; try { jsonObject = new JSONObject(str); } catch (JSONException e) {
     * e.printStackTrace(System.err); } return jsonObject;
     */
    public static void main(String[] args) {
        TS t = new TS();
        t.as();
    }

}
