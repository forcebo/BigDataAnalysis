package com.skd.requirements;

import com.skd.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class chart4 {
    //    1.统计每个用户的消费总数，并找出排名前10的用户
    public void require() throws Exception {
        Connection mysqlCon = ConnectionUtil.getMysqlCon();
        Connection hiveCon = ConnectionUtil.getHiveCon();
        String hive_sql = "select title,goodCountStr from t_real_headphone order by cast(goodCountStr as int) desc limit 10";
        PreparedStatement ps = hiveCon.prepareStatement(hive_sql);
        ResultSet rs = ps.executeQuery();
        //想想为何要讲结果放入mysql当中
        String mysql_sql = "insert into speaker_gcomment (s_title,s_goodgoodCountStr) values (?,?)";
        ps = mysqlCon.prepareStatement(mysql_sql);
        while (rs.next()) {
           System.out.println(rs.getString(1) + "-----" + rs.getString(2));
            //以上步骤没有问题（能够从hive中获取到数据再进行下面的操作）
            // ps.setString(1, rs.getString(1));
            // ps.setString(2, rs.getString(2));
            // ps.executeUpdate();
        }
        ConnectionUtil.closeCon(mysqlCon, hiveCon);
    }


    public static void main(String[] args) throws Exception {
        System.out.println("进行中...");
        new chart4().require();
        System.out.println("完成");
    }
}
