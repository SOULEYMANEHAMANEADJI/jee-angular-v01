package sn.dev.examenjeeangularditi4s4.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private  String url="jdbc:mysql://localhost:3307/jee_diti4_db";
    private String user = "root";
    private String password = "Luqm@n21";


    public Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to database successfully !");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Could not connect to database !");
            throw new RuntimeException(e);
        }
        return  connection;
    }
}
