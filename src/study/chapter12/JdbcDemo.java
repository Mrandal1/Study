package study.chapter12;

import java.sql.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter12
 * @data 2020/5/8 22:24
 */
public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        /*
         *  Statement       public interface Statement extends Wrapper, AutoCloseable
         *      每一个sql操作都是一个Statement对象
         *
         *      数据更新处理  ；（INSERT UPDATE　DELETE）  int executeUpdate(String sql) throws SQLException;(返回修改行数)
         *      数据查询处理  ：(SELECT )   ResultSet executeQuery(String sql) throws SQLException;
         *
         *
         * */
        /*加载驱动*/
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/job";
        String user = "root";
        String password = "root";
        Connection con = null;
        con = DriverManager.getConnection(url, user, password);
        /*查询*/
        String sql = "SELECT * FROM workinfo WHERE id='1'";
        Statement statement = con.createStatement();
        try (ResultSet set = statement.executeQuery(sql)) {
            while (set.next()) {
                System.out.println(set.getInt(1) + "\t" +
                        set.getString(2) + "\t" + set.getString(3) + "\t" +
                        set.getInt(4) + "\t" + set.getString(5) + "\t" + set.getString(6));
            }
        }
        String sql1 = "INSERT INTO workinfo(id,name,sex,age,address,tel)VALUES(10,'小红','女',15,'上海','123423')";
        int re = statement.executeUpdate(sql1);
        System.out.println("修改了" + re + "行");
        String sql2 = "UPDATE workinfo SET name='小明' WHERE name='小红'";
        System.out.println("修改了" + statement.executeUpdate(sql2) + "行");
        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO workinfo(id,name,sex,age,address,tel)VALUES(?,?,?,?,?,?)");
        preparedStatement.setInt(1, 9);
        preparedStatement.setString(2, "小王");
        preparedStatement.setString(3, "男");
        preparedStatement.setInt(4, 32);
        preparedStatement.setString(5, "北京");
        preparedStatement.setString(6, "3535323");
        System.out.println("修改了" +preparedStatement.executeUpdate()+ "行");


    }
}
