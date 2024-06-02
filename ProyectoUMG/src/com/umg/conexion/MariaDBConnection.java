package com.umg.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConnection {
	
	private static final String URL = "jdbc:mariadb://localhost:3306/proyectoumg?permitMysqlScheme";

    private static final String USUARIO = "root";

    private static final String CONTRASE�A = "12345";
    
    
    public static Connection getConnection() {

        Connection conn = null;

        try {

            Class.forName("org.mariadb.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USUARIO, CONTRASE�A);

            return conn;

        } catch (SQLException e) {

            System.out.println("Error al conectar a la base de datos: " + e.getMessage());

            return null;

        } catch (ClassNotFoundException e) {

            System.out.println("No se encontr� el controlador JDBC" + e.toString());

            return null;

        }
    }
}