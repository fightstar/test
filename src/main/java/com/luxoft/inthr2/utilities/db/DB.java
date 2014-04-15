package com.luxoft.inthr2.utilities.db;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: ihnedysh
 * Date: 26.11.13
 * Time: 19:59
 * To change this template use File | Settings | File Templates.
 */
public class DB {
    private String url;
    private String login;
    private String password;
    String DRIVER_CLASS_NAME = "net.sourceforge.jtds.jdbc.Driver";



   /* @Autowired
    private SimpleDriverDataSource dataSource;*/

    private Connection con = null;

    public void executeSelectQuery(String sql) {  //доработать  парсинг ResultSet
        Statement stmt = null;                 // возможно нужно возвращать  ResultSet
        try {                                  // а парсить снаружи
            stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            System.out.println(result.getMetaData());
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            closeStmt(stmt);
        }
    }

    public int executeUpdateQuery(String sql) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            return stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            closeStmt(stmt);
        }
    }


    private void closeStmt(Statement stmt){
        if (stmt != null) {
            try {
                stmt.close();
                System.out.println("statement closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeDBConnection(){
        if (con != null) {
            try {
                con.close();
                System.out.println("connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public DB(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;

        try {
            Class.forName(DRIVER_CLASS_NAME).newInstance();
        }
        catch (Exception ex){
            System.out.println("Check classpath. Cannot load db driver: " + DRIVER_CLASS_NAME);
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        try {
            con = DriverManager.getConnection(url, login, password);

            System.out.println("Connect " + url);
        } catch (SQLException e) {
            System.out.println("SQLException" + e.getMessage());


        }


    }


}
