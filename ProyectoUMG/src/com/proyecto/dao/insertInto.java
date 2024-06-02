package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umg.conexion.MariaDBConnection;



public class insertInto {

	public static boolean productos( String nombre, String marca, 
    		String precio,String categoria, String stock) {

        Connection conn = MariaDBConnection.getConnection();

        if (conn != null) {

            try {

                String consulta = "INSERT INTO productos (nombre, marca, precio, categoria, stock) VALUES (?, ?, ?, ?, ?)";

                PreparedStatement statement = conn.prepareStatement(consulta);


                statement.setString(1, nombre);
                statement.setString(2, marca);
                statement.setString(3, precio);
                statement.setString(4, categoria);
                statement.setString(5, stock);

                int filasInsertadas = statement.executeUpdate();
                
                System.out.println("Se registro " + filasInsertadas + " producto con exito!");

                statement.close();

                conn.close();

                return filasInsertadas > 0;

            } catch (SQLException e) {

                System.out.println("Error al crear producto: " + e.getMessage());

                return false;

            }

        } else {

            System.out.println("No se pudo establecer la conexión.");

            return false;

        }
        
    }
   
}
