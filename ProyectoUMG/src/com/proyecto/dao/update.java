package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umg.conexion.MariaDBConnection;

public class update {

	public static void main(String[] args) {
		// Metodo para actualizar un registro

			}	
				public static boolean productos (int productoId, String nombre, String marca, String precio, String categoria, String stock) {
				
				Connection conn = MariaDBConnection.getConnection();

		        if (conn != null) {

		            try {

        String consulta = "UPDATE productos SET nombre = ?, marca = ?, precio = ?, categoria = ?, stock = ? WHERE idproducto =" + productoId;

		                PreparedStatement statement = conn.prepareStatement(consulta);	                               
		                
		                statement.setString(1, nombre);
		                statement.setString(2, marca);
		                statement.setString(3, precio );
		                statement.setString(4, categoria );
		                statement.setString(5, stock);
		                
		                int filasActualizadas = statement.executeUpdate();

		                statement.close();

		                conn.close();

		                return filasActualizadas > 0;

		            } catch (SQLException e) {

		                System.out.println("Error al actualizar producto: " + e.getMessage());

		                return false;

		            }

		        } else {

		            System.out.println("No se pudo establecer la conexión.");

		            return false;

		        }

    }
}