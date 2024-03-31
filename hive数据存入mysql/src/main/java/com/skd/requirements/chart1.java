package com.skd.requirements;

import com.skd.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class chart1 {
    //    1.统计耳机相关数据，并找出评论总数排名前10的耳机
    public void require() throws Exception {
        Connection mysqlCon = ConnectionUtil.getMysqlCon();
        Connection hiveCon = ConnectionUtil.getHiveCon();
        String hive_sql = "select title,commentCountStr from t_real_headphone order by cast(commentCountStr as int) desc limit 10";
        PreparedStatement ps = hiveCon.prepareStatement(hive_sql);  //执行sql（hive）
        ResultSet rs = ps.executeQuery();  //rs ---hive中的分析结果，不是原始数据

        String mysql_sql="insert into headphone_comment (h_title,h_commentCountStr) values (?,?)";
        ps = mysqlCon.prepareStatement(mysql_sql);
        while (rs.next()) {
            ps.setString(1,rs.getString(1));
            ps.setString(2,rs.getString(2));
            ps.executeUpdate();
        }

    }
    public static void main(String[] args) throws Exception {
        System.out.println("进行中...");
        new chart1().require();
        System.out.println("完成");
    }

}