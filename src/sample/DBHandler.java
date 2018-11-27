package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHandler {
//    Connection dbConnection;
//    private String dbHost = "localhost";
//    private String dbPort = "3306";
//    private String dbName = "wsr";
//    private String dbUser = "root";
//    private String dbPass = "4213";
//
//    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
//        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?characterEncoding=utf-8";
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
//        if (!dbConnection.isClosed()){
//            System.out.println("connection opened");
//        }
//        return dbConnection;
//    }
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
    try {
        //Your database url string,ensure it is correct
        String url = "jdbc:mysql://localhost:3306/wsr"+
                "?characterEncoding=utf-8"+
                "&verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";

        String user = "root";
        String password = "4213";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);

        if (!conn.isClosed()){
            System.out.println("connection opened");
        }

        return conn;

    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }

        return null;
    }
}
