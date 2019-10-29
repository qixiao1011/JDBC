package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseController {
    Connection connection;
    PreparedStatement preparedStatement;
     public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/qixiao?characterEncoding=utf-8","root","199710");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("连接失败");
        }
        return connection;
     }
     //查
    public ResultSet query(String sql){
         getConnection();
         try {
             preparedStatement = connection.prepareStatement(sql);
             ResultSet set=preparedStatement.executeQuery();
             return set;
         }catch(Exception e){
             System.out.println("查询失败");
             e.printStackTrace();
         }
            return null;
         }
         //改动
    public int change(String sql,Object...objs){
         getConnection();
         try{
             preparedStatement=connection.prepareStatement(sql);
             for(int i=0;i<objs.length;i++){
                 preparedStatement.setObject(i+1,objs[i]);
             }
             int rows=preparedStatement.executeUpdate();
             return rows;
         }catch(Exception e){
             e.printStackTrace();
         }
         return -1;
    }

    //关闭连接
    public void closeConnection(){
         try {
             if (connection != null) {
                 connection.close();
             }
             if (preparedStatement != null) {
                 preparedStatement.close();
             }
         }catch(Exception e){
             e.printStackTrace();
         }
    }
}
