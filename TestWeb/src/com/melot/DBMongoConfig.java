package com.melot;

import java.net.UnknownHostException;

import com.mongodb.Mongo;

public class DBMongoConfig {

    // 获取连接 localhost 端口:27017
    public static Mongo mongo = null;

    public static Mongo getHost() {
        try {
            if (null != mongo) {
                System.out.println("error");
            } else {
                mongo = new Mongo("localhost", 27017);
                System.out.println(mongo + "===================");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return mongo;

    }

    public static String getDbName() {
        if (null != mongo) {
            System.out.println("error");
        } else {
            getHost().getDB("mydb");
            System.out.println(mongo + "===================");
        }
        return null;

    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        DBMongoConfig d = new DBMongoConfig();
        d.getHost();
    }
}
