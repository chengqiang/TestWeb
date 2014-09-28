package com.melot;

import java.net.UnknownHostException;

import com.mongodb.Mongo;

public class MongoDBClient {

    // 获取连接 localhost 端口:27017
    public Mongo mongo = null;

    public Mongo dbConnection() {
        try {
            if (null != mongo) {
                System.out.println("error");
            } else {
                mongo = new Mongo("localhost", 27017);
                System.out.println(this.mongo + "-------is mongo info");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return mongo;

    }

    public Mongo dbConnection2() {
        try {
            if (null != mongo) {
                System.out.println("error2");
            } else {
                mongo = new Mongo("localhost", 27017);
                mongo.getDB(DatabaseCoon.mydb).getCollection(TableName.employees);
                System.out.println(this.mongo + "-------is mongo2 info");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return mongo;

    }
    
  /*  static void Main(string[] args)    
    {    
        indexBll indexBll = new IndexBLL();    
        indexBll.DropAllIndex();    
        indexBll.DeleteAll();    
        indexBll.InsertBigData();    
        Stopwatch watch1 = new Stopwatch();    
        watch1.Start();    
        for (int i = 0; i < 1; i++) indexBll.SortForData();    
        Console.WriteLine("无索引排序执行时间：" + watch1.Elapsed);    
        indexBll.CreateIndexForData();    
        Stopwatch watch2 = new Stopwatch();    
        watch2.Start();    
        for (int i = 0; i < 1; i++) indexBll.SortForData();    
        Console.WriteLine("有索引排序执行时间：" + watch2.Elapsed);    
    } */
    public static void main(String[] args) {
        MongoDBClient mongcClient = new MongoDBClient();
        mongcClient.dbConnection();
    }

}
