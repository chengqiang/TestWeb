package com.melot.pub;
/*package cn.melot.jdbc;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.Bytes;
import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import com.mongodb.QueryOperators;
import com.mongodb.WriteResult;
import com.sun.tools.javac.util.List;

public class s {
    MongoURI uri = new MongoURI("mongodb://localhost:27017");
    String databaseName ="myDatabase";
    String collectionName = "mycollections";

    Mongo mongo = null;
    DB db = null;
    DBCollection userCollection;
        //  定义Mongo服务
            mongo =new Mongo("localhost", 27017);
            mongo = new Mongo(uri);


           mongo = new Mongo();
           DBAddress addr = new DBAddress("localhost", 27017,databaseName);
            mongo.connect(addr);

      //  删除数据库
        mongo.dropDatabase(databaseName);

     //  获取databaseName对应的数据库，不存在则自动创建
        db = mongo.getDB(databaseName);

      //  添加用户
        db.addUser("admin", new char []{'a','d','m','i','n'});

      //  移除用户
        db.removeUser("admin");

      //  验证权限
        boolean flag = db.authenticate("admin", new char []{'a','d','m','i','n'} );

        if(flag == false){
            return;
        }

      //  设置db为只读 ，只读就不能写入数据了   对save管用，对insert好像不管用
       db.setReadOnly(true);



       // 获取collectionName对应的集合，不存在则自动创建
        db.createCollection("mycollection", new BasicDBObject());
        userCollection = db.getCollection(collectionName);


       // 查询所有的DataBase
        for(String dbName : mongo.getDatabaseNames()){
            System.out.println("databasename:" + dbName);
        }


       // 查询所有的聚集集合
        for(String collection :db.getCollectionNames()){
            System.out.println("collectionName:" + collection);
        }


       // 查询是否存在collectionName集合
        if(db.collectionExists(collectionName)){
          //去掉重复的数据
           java.util.List<Object> dislist = userCollection.distinct("userId");
           int len = dislist.size();
         for(int i = 0 ; i< len ; i++){
               System.out.println(dislist.get(i));
           }

       //     查询
            System.out.println(userCollection.find(new BasicDBObject("userId",1)).toArray());

       //     返回前2个

   //System.out.println(userCollection.find({},{reviews:{slice:2}});                                 

System.out.println("分页："+userCollection.find(new BasicDBObject("",new BasicDBObject("slice", 2))).toArray());

      //      查询所有的数据
     //       DB游标
            DBCursor cursor = userCollection.find();
            while(cursor.hasNext()){
                DBObject userDbobj = cursor.next();             
                System.out.println("userId:"+userDbobj.get("userId")+";age:"+userDbobj.get("age")+";sex:"+userDbobj.get("sex")+";address:"+userDbobj.get("address"));
            }


         //   条件查询
            //查询age 等于 24
            System.out.println("find age = 24: " + userCollection.find(new BasicDBObject("age", 24)).toArray());


        //    查询age 大于等于 24
            System.out.println("find age >= 24: " + userCollection.find(new BasicDBObject("age", new BasicDBObject("gte",24))).toArray());               

          //  查询age小于等于24            System.out.println("findage<=24:"+userCollection.find(newBasicDBObject("age",newBasicDBObject("lte", 24))).toArray());


          //  查询age 不等于25
            System.out.println("查询age!=25：" + userCollection.find(new BasicDBObject("age", new BasicDBObject("$ne", 25))).toArray());

          //  查询某个范围的数据
            System.out.println("查询age in 25/26/27：" + userCollection.find(new BasicDBObject("age", new BasicDBObject(QueryOperators.IN, new int[] { 25, 26, 27 }))).toArray());

        //   查询不在某个范围数据
            System.out.println("查询age not in 25/26/27：" + userCollection.find(new BasicDBObject("age", new BasicDBObject(QueryOperators.NIN, new int[] { 25, 26, 27 }))).toArray());

            //按age排序
            System.out.println("查询age exists 排序：" + userCollection.find().sort(new BasicDBObject("age",new BasicDBObject(QueryOperators.ORDER_BY, 1))).limit(2).skip(1).toArray());   //(new BasicDBObject("age", new BasicDBObject(QueryOperators.ORDER_BY, 1))).toArray());

            new BasicDBObject();

            System.out.println("只查询age属性：" + userCollection.find(null, new BasicDBObject("age", true)).toArray());

            System.out.println("只查属性：" + userCollection.find(null, new BasicDBObject("age", true), 0, 2).toArray());

            System.out.println("只查属性：" + userCollection.find(null, new BasicDBObject("age", true), 0, 2, Bytes.QUERYOPTION_NOTIMEOUT).toArray());
        }


      //  添加数据
        DBObject user = new BasicDBObject();
        user.put("userId", 2);
        user.put("userName", "tom");
        user.put("age", 21);
        user.put("sex", "male");
        user.put("address", "北京海淀");

        userCollection.save(user);

      //  getN  对save和insert不管用
       WriteResult saveResult = userCollection.save(user);
       System.out.println(saveResult.getN());
       System.out.println(saveResult.isLazy());
      if(saveResult.getN() > 0){
           System.out.println("添加成功");
       }


       // 添加List集合
       ArrayList<DBObject> list = new ArrayList<DBObject>();
       list.add(user);
        DBObject user2 = new BasicDBObject();
       user2.put("userId", 2);
      user2.put("userName", "lily");
       user2.put("age", 20);
       user2.put("sex", "female");
       user2.put("address", "新加坡");
       list.add(user2);

       userCollection.insert(list);
      //  看是否插入成功
        System.out.println("集合中数据量：" + userCollection.count());



   //     删除数据
       WriteResult wr = userCollection.remove(new BasicDBObject("userId",1));
       System.out.println(wr.getN());
       System.out.println(wr.isLazy());
       if(wr.getN() > 0){
           System.out.println("删除成功！");
     }


     //   删除整个集合
        userCollection.drop();


        //修改
        DBObject newUser =new  BasicDBObject();
        newUser.put("userId", 3);
        newUser.put("userName", "tomAndKitty");
        newUser.put("age", 25);
        user.put("sex", "male");
        user.put("address", "北京朝阳");


      WriteResult updateResult = userCollection.update(new BasicDBObject("userId",1),newUser);
      //WriteResult updateResult = userCollection.update(new BasicDBObject("userId",3),newUser,

      //  关闭Mongo服务
        if(mongo != null){
            mongo.close();
        }
        db = null;
        userCollection = null;
    }
}*/