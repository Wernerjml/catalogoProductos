package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umg.conexion.MariaDBConnection;

public class delete {

	public static void main(String[] args) {
		//Metodo para eliminar un registro de estudiante

	}
	

	public static boolean producto (int idproducto) {
	
	    Connection conn = MariaDBConnection.getConnection();
	
	    if (conn != null) {
	
	        try {
	
	            String consulta = "DELETE FROM productos WHERE idproducto = ?";
	
	            PreparedStatement statement = conn.prepareStatement(consulta);
	
	            statement.setInt (1, idproducto);
	
	            int filasEliminadas = statement.executeUpdate();
	
	            statement.close();
	
	            conn.close();
	
	            return filasEliminadas > 0;
	
	        } catch (SQLException e) {
	
	            System.out.println("Error al eliminar el producto: " + e.getMessage());
	
	            return false;
	
	        }
	
	    } else {
	
	        System.out.println("No se pudo establecer la conexión.");
	
	        return false;
	
	    }
	
	}
	
}
