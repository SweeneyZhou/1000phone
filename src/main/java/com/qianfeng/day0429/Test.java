package com.qianfeng.day0429;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Test {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2101?serverTimezone=Asia/Shanghai", "root", "123456");
            Statement statement = con.createStatement();

            System.out.print("请输入用户名:");
            String username=scanner.next();
            System.out.print("请输入密码:");
            String password=scanner.next();
            String sql ="SELECT * FROM Users WHERE username='"+username+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                int userId=resultSet.getInt("id");
                if (resultSet.getString("password").equals(password)){
                    SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String date=sdf.format(resultSet.getTimestamp("last_login_time"));
                    System.out.println("登录成功！您上次登录时间为:"+date);
                    statement.executeUpdate("UPDATE Users SET last_login_time=now() WHERE id="+userId);
                }else {
                    System.out.println("密码错误，请重新登录！");
                }
            }else {
                System.out.println("用户名不存在！开始注册...");
                if(registry(statement)>0){
                    System.out.println("注册成功！重启程序以登录！");
                }else{
                    System.out.println("注册失败！！");
                }
            }
            resultSet.close();
            statement.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            scanner.close();
        }
    }

    public static int registry(Statement statement) throws SQLException {
        String username;
        while (true) {
            System.out.print("请输入用户名:");
            username = scanner.next();
            ResultSet rs=statement.executeQuery("select 1 from users where username='"+username+"'");
            if (!rs.next())break;
            else System.out.println("用户名已存在请重新输入！");
        }

        System.out.print("请输入密码:");
        String password=scanner.next();
        String sql="insert into USERS(username,password) values ('"+username+"','"+password+"')";
        return statement.executeUpdate(sql);
    }
}
