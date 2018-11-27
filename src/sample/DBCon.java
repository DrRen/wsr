package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBCon {

    public Connection Connect(){

        String URL = "jdbc:mysql://localhost:3306/wsr"+
                "?characterEncoding=utf-8"+
                "&serverTimezone=UTC"+
                "&useLegacyDatetimeCode=false";

        String user = "root";
        String pass = "4213";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL,user,pass);

            return conn;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
