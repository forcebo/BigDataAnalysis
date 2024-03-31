package com.skd.requirements;

import com.skd.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class chart3 {

    //    3.统计购买手机的用户占全部用户的比例
    public void require() throws Exception {
        Connection mysqlCon = ConnectionUtil.getMysqlCon();
        Connection hiveCon = ConnectionUtil.getHiveCon();
        String hive_sql = "select title,commentCountStr from t_real_speaker order by cast(commentCountStr as int) desc limit 10";
        PreparedStatement ps = hiveCon.prepareStatement(hive_sql);
        ResultSet rs = ps.executeQuery();
        String mysql_sql="insert into speaker_comment (s_title,s_commentCountStr) values (?,?)";
        ps = mysqlCon.prepareStatement(mysql_sql);
        while (rs.next()) {
            System.out.println(rs.getString(1) + "-----" + rs.getString(2));
            // ps.setString(1,rs.getString(1));
            // ps.setString(2,rs.getString(2));
            // ps.executeUpdate();
        }
        ConnectionUtil.closeCon(mysqlCon,hiveCon);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("进行中...");
        new chart3().require();
        System.out.println("完成");
    }
}
