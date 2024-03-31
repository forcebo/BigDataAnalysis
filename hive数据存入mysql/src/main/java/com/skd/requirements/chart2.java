package com.skd.requirements;

import com.skd.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class chart2 {
    //    2.统计每个商品（title）的购买次数，并找出热卖前5的商品
    public void require() throws Exception {
        Connection mysqlCon = ConnectionUtil.getMysqlCon();
        Connection hiveCon = ConnectionUtil.getHiveCon();
        String hive_sql = "select title,goodCountStr from t_real_headphone order by cast(goodCountStr as int) desc limit 10";
        PreparedStatement ps = hiveCon.prepareStatement(hive_sql);
        ResultSet rs = ps.executeQuery();
        String mysql_sql="insert into headphone_gcomment (h_title,h_goodcommentCountStr) values (?,?)";
        ps = mysqlCon.prepareStatement(mysql_sql);
        while (rs.next()) {
            ps.setString(1,rs.getString(1));
            ps.setString(2,rs.getString(2));
            ps.executeUpdate();
        }
        ConnectionUtil.closeCon(mysqlCon,hiveCon);
    }
    public static void main(String[] args) throws Exception {
        System.out.println("进行中...");
        new chart2().require();
        System.out.println("完成");
    }
}
