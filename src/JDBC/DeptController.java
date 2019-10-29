package JDBC;

import java.sql.ResultSet;

public class DeptController extends BaseController{

    //查询所有
    public ResultSet findall(){
        String sql="select * from dept";
        ResultSet set=query(sql);
        try {
            while (set.next()){
               String deptno=set.getString(1);
               String dname=set.getString(2);
               String loc=set.getString(3);
                System.out.println("Deptno"+deptno+"   "+"dname"+dname+"   "+"loc"+loc+"   ");
            }
        }catch(Exception e){
            System.out.println("查询失败");
            e.printStackTrace();
        }
        closeConnection();
        return set;
    }
    //删
    public int delete(int a){
        String sql="delete from Dept where deptno="+a;
        int rows=change(sql);
        if (rows>0){
            System.out.println("删除成功");
            findall();
            return rows;
        }
        return -1;
    }
   // 增
   public int insert(String Deptno,String dname,String loc){
       String sql="insert into dept (deptno,dname,loc) values (?,?,?)";
       int a=change(sql,Deptno,dname,loc);
       if (a>0){
           System.out.println("增加成功");
           findall();
           return a;
       }
       return -1;
   }
   //改
    public int changeByid(String Deptno,String dname,String loc){
        String sql="update dept set dname=?,loc=? where Deptno=?";
         int rows=change(sql,dname,loc,Deptno);
        if (rows>0){
            System.out.println("修改成功");
            findall();
            closeConnection();
            return rows;
        }
        return -1;
    }

}
