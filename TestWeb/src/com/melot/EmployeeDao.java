package com.melot;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

/**
 * 类EmployeeDao.java的实现描述：TODO 类实现描述
 * 
 * @author chengqiang 2014年9月1日 下午4:22:33
 */
public class EmployeeDao {

    public Mongo               mogo       = new MongoDBClient().dbConnection();
    // 获取数据库，如果没有/自动创建db_Name
    public final DB            db         = this.mogo.getDB("mydb");
    // 获取表名，如果没有自己动创建
    private final DBCollection collection = this.db.getCollection(TableName.employees);

    /**
     * 添加
     */
    public void insert() {
        BasicDBObject employee = baseObject();
        employee.put("name", "D");
        employee.put("no", 2);
        employee.put("sex", "F");
        employee.put("age", 31);
        //
        this.collection.insert(employee);
        // 添加失败
        this.collection.setWriteConcern(WriteConcern.SAFE);
    }

    /**
     * 查询
     */
    public void query() {
        BasicDBObject searchEmployee = baseObject();
        searchEmployee.put("no", 2);// 条件K,V
        DBCursor cursor = collection.find(searchEmployee);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
        System.out.println("查询数据........");

    }

    /**
     * 查询一条记录
     */
    public void queryone() {
        // findOne()返回一个记录，而find()返回的是DBCursor游标对象。
        DBObject firstDoc = this.collection.findOne();
        System.out.println(firstDoc);
    }

    /**
     * 按条件查询结果记录数
     */
    public void getCount() {
        DBObject query = new BasicDBObject("no", 2);
        long count = this.collection.count(query);
        System.out.println(count);
    }

    /**
     * 修改
     */
    public void update() {
        BasicDBObject employee = new BasicDBObject();
        employee.put("name", "A");
        DBObject dbObject = this.collection.findOne(employee);
        dbObject.put("name", dbObject.get("name") + "AUPDATA");
        this.collection.update(employee, dbObject);
    }

    /**
     * 条件删除
     */
    public void deleteByName() {
        BasicDBObject query = new BasicDBObject();
        query.put("name", "B");
        // 找到并且删除，并返回删除的对象
        DBObject removeObj = this.collection.findAndRemove(query);
        System.out.println(removeObj);
    }

    /**
     * 公共方法
     * 
     * @return
     */
    private BasicDBObject baseObject() {
        BasicDBObject searchEmployee = new BasicDBObject();
        return searchEmployee;
    }

    /**
     * 移除
     */
    public void remore() {
        BasicDBObject employee = baseObject();
        employee.put("age", 18);// 条件K,V
        this.collection.remove(employee);
    }

    /**
     * 创建索引
     * 
     * @param collectionName
     * @param options
     */
    public void createIndex() {
        this.collection.createIndex(new BasicDBObject("i", 1));
    }

    /**
     * 获取索引信息
     */
    public void getIndexInfo() {
        java.util.List<DBObject> list = this.collection.getIndexInfo();
        for (DBObject o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        EmployeeDao d = new EmployeeDao();
        // d.insert();
        // 移除 根据条件
        // d.remore();
        // 修改 根据条件
        // d.update();
        // 删除 根据名称
        // d.deleteByName();
        // 根据条件查询结果记录数
        // d.getCount();
        // 查询一条
        // d.queryone();
        // 创建索引
        // d.createIndex();
        // 查询索引
        // d.getIndexInfo();
        // 查询所有
        d.query();
    }
}
