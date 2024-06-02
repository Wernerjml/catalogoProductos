package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.umg.conexion.MariaDBConnection;

public class selectUpdate {

	public static void main(String[] args) {
		// Metodo para mostrar en pantalla el registro a modificar
		leerSelect();
	}
	    public static void leerSelect() {
	        Connection conn = MariaDBConnection.getConnection();
	        if (conn != null) {
	            try {
	            	Scanner leerselectupdate = new Scanner (System.in);
	            	String idproducto;
	            	System.out.println("Escriba numero de ID del producto a modificar");
	                idproducto = leerselectupdate.nextLine();
	            	String consulta = "SELECT * FROM productos WHERE idproducto =" + idproducto;
	                PreparedStatement statement = conn.prepareStatement(consulta);
	                ResultSet resultSet = statement.executeQuery();
	                while (resultSet.next()) {
	                    int productoId = resultSet.getInt("idproducto");
	                    String nombreProducto = resultSet.getString("nombre");
	                    String marcaProducto = resultSet.getString("marca");
	                    String precioProducto = resultSet.getString("precio");
	                    String categoriaProducto = resultSet.getString("categoria");
	                    int stockProducto = resultSet.getInt("stock");

	                    System.out.println("Usted Modificara el siguiente registro: " + "\n\nId: " + productoId + ",  Nombre: " + nombreProducto + ", Marca: " + marcaProducto + ", Precio: " + precioProducto + ", Categoria: " + categoriaProducto + ", Stock: " + stockProducto + "\n");
	                }
	                resultSet.close();
	                statement.close();
	                conn.close();
	            } catch (SQLException e) {
	                System.out.println("Error al leer productos: " + e.getMessage());
	            }
	        } else {
	            System.out.println("No se pudo establecer la conexión.");
	        }
	    }
}