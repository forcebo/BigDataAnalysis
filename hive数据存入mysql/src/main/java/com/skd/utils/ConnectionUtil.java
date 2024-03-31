package com.skd.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionUtil {

    //  mysql
    static Connection mysqlCon = null;
    private static String mysql_driver;
    private static String mysql_url = null;
    private static String mysql_user = null;
    private static String mysql_password = null;
    //  hive
    static Connection hiveCon = null;
    private static String hive_driver;
    private static String hive_url = null;
    private static String hive_user = null;
    private static String hive_password = null;

    static {
        try {
            loadProperties();
            Class.forName(mysql_driver);
            Class.forName(hive_driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadProperties() throws IOException {  //加载资源文件（外配的文件）
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("db");  //读取配置文件
            mysql_driver = bundle.getString("mysql.driver"); //根据键获取值
            mysql_url = bundle.getString("mysql.url");
            mysql_user = bundle.getString("mysql.user");
            mysql_password = bundle.getString("mysql.password");

            hive_driver = bundle.getString("hive.driver");
            hive_url = bundle.getString("hive.url");
            hive_user = bundle.getString("hive.user");
            hive_password = bundle.getString("hive.password");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(mysql_driver);
//        System.out.println(mysql_url);
//        System.out.println(mysql_user);
//        System.out.println(mysql_password);
//        System.out.println("-----------------------");
//        System.out.println(hive_driver);
//        System.out.println(hive_url);
//        System.out.println(hive_user);
//        System.out.println(hive_password);
    }

//    public static void main(String[] args) throws IOException {
//        ConnectionUtil.loadProperties();
//    }

    public static Connection getMysqlCon() throws Exception {  //获取mysql的连接
        mysqlCon = DriverManager.getConnection(mysql_url, mysql_user, mysql_password);
        return mysqlCon;
    }

    public static Connection getHiveCon() throws Exception { //获取hive的连接
        hiveCon = DriverManager.getConnection(hive_url, hive_user, hive_password);
        return hiveCon;
    }

    public static void closeCon(Connection mysqlCon,Connection hiveCon) throws Exception { //关闭连接
        if(mysqlCon!=null){
            mysqlCon.close();
        }
        if(hiveCon!=null){
            hiveCon.close();
        }
    }

}
