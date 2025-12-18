package JDBC;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Demo1 {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        //1.创建“数据源”
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java118?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("0614");

        //2.和数据库服务器建立连接
        Connection connection = dataSource.getConnection();

        //3.mysql认识sql语句，想让Java操作数据库，本质上让Java代码构造出一个sql语句的字符串
        //发送给服务器
        //字符串的SQL不符合JDBC的要求，JDBC需要通过SQL字符串构造出“语句”对象
        System.out.println("请输入学号");
        int id = sc.nextInt();
        System.out.println("请输入姓名");
        String name = sc.next();

//        String sql = "insert into student values("+id+",'"+name+"')";
        String sql = "insert into student values(?,?)";
        //Statement statement = connection.createStatement();
        PreparedStatement statement = connection.prepareStatement(sql);//预处理语句，推荐使用
        statement.setInt(1, id);
        statement.setString(2, name);

        //4.执行SQL语句
        int n = statement.executeUpdate();
        System.out.println("n = "+n);//表示影响了n行数据

        //5.代码中要释放上述资源，释放顺序和创建顺序要相反
        statement.close();
        connection.close();

    }
}
