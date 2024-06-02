package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.umg.conexion.MariaDBConnection;

public class selectCategoria {

	public static void main(String[] args) {
		// Metodo para consultar la base de datos por categoria
		leerSelect();
	}
	    public static void leerSelect() {
	        Connection conn = MariaDBConnection.getConnection();
	        if (conn != null) {
	            try {
	            	Scanner leer = new Scanner (System.in);
	            	String categoria;
	            	System.out.println("Escriba en minusculas la categoria de los productos a mostrar \n(perifericos, componentes, notebook o desktop)\n");
	                categoria = leer.nextLine();
	                
	                System.out.println("\nLos siguientes productos corresponden a la categoria " + categoria + ":\n\n");
	            	String consulta = "SELECT * FROM productos WHERE categoria = " + "'"+categoria+"'";
	                PreparedStatement statement = conn.prepareStatement(consulta);
	                ResultSet resultSet = statement.executeQuery();
	                while (resultSet.next()) {
	                    int productoId = resultSet.getInt("idproducto");
	                    String nombreProducto = resultSet.getString("nombre");
	                    String marcaProducto = resultSet.getString("marca");
	                    String precioProducto = resultSet.getString("precio");
	                    String categoriaProducto = resultSet.getString("categoria");
	                    int stockProducto = resultSet.getInt("stock");

	                    System.out.println("Id: " + productoId + ",  Nombre: " + nombreProducto + ", Marca: " + marcaProducto + ", Precio: " + precioProducto + ", Categoria: " + categoriaProducto + ", Stock: " + stockProducto);
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