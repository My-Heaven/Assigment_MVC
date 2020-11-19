/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.utitil;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Tan DaT
 */
public class DBHelper implements Serializable{
    public static Connection makeConnection() throws /*ClassNotFoundException*/NamingException, SQLException{
        //1. lay context hien hanh
        Context context = new InitialContext();
        Context tomcatContext= (Context) context.lookup("java:comp/env");
        //3. lay datasource
        DataSource ds = (DataSource)tomcatContext.lookup("SE141118");
        //4. tao connection tu datasource
        Connection con =ds.getConnection();
        return con;
        //2. lay context cua server
//        //1. load driver
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        //2. create connection
//        String url ="jdbc:sqlserver://localhost:1433;databaseName=Information";
//        //3. open connection
//        Connection con =DriverManager.getConnection(url, "sa", "dat123");
//        return con;
    }
}
