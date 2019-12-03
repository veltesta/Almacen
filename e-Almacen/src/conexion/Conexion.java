/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class Conexion {
    //imcorporar libreria SQL
    private static String driver = "com.mysql.jdbc.Driver";
    //nombre de la base de datos
    private static String database = "almacen";
    // servidor
    private static String hostname = "localhost";
    //puerto
    private static int port = 3306;
    //usuario
    private static String username = "root";
    
    private static String password = "";
    //url de conexion a la base de datos
    private static String connectionURL;
    //conector
    public static Connection conn;
    
    public Conexion(){
        this.connectionURL = "jdbc:mysql://"+hostname+ ":" +port+ "/" + database;
        this.getconnection();
    }
    
    public static Connection getconnection(){
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(hostname);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(database);
        datasource.setPortNumber(port);
        try {
            Class.forName(driver);
            try {
            conn = (Connection) datasource.getConnection();
            } catch(SQLException ex){
            System.out.println("Error al crear conector: "+ ex.getMessage());
            }
    } catch(ClassNotFoundException ex) {
    
    }
    return conn;
}
}
