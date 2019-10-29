package JDBC;

public class Test {
    public static void main(String[] args) {
        DeptController dept=new DeptController();
       // dept.insert("80","王力宏","盖世英雄");
        dept.changeByid("80","王力宏","多牛逼呀");
    }
}
