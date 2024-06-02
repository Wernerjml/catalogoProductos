package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.proyecto.dao.delete;
import com.proyecto.dao.insertInto;
import com.proyecto.dao.select;
import com.proyecto.dao.selectCategoria;
import com.proyecto.dao.selectDelete;
import com.proyecto.dao.selectUpdate;
import com.proyecto.dao.update;

public class main {

	public static void main(String[] args) {
	      Scanner sn = new Scanner(System.in);

	      boolean salir = false;
	      int opcion;

	      while(!salir){

	         System.out.println("\t-- PROGRAMA PARA LA GESTION DE PRODUCTOS --");

	         System.out.println("\n1.- Ingresar un producto");
	         System.out.println("2.- Mostrar stock de productos");
	         System.out.println("3.- Mostrar stock de productos por categoria");
	         System.out.println("4.- Modificar el registro de un producto");
	         System.out.println("5.- Eliminar el registro de un producto");
	         System.out.println("6.- Salir");

	         try{

	            System.out.println("\nIngrese el numero de la gestion a realizar: ");
	            opcion = Integer.parseInt(sn.nextLine());

	            switch (opcion){
	            case 1:
	            	Scanner leer = new Scanner(System.in);
	        		
	        		
	        		System.out.println("\nIngrese el nombre del producto: ");
	        		String nombre = leer.nextLine();
	        		
	        		System.out.println("Ingrese la marca del producto: ");
	        		String marca = leer.nextLine();
	        		
	        		System.out.println("Ingrese el precio del producto: ");
	        		String precio = leer.nextLine();
	        		
	        		System.out.println("Ingrese la categoria del producto (perifericos, componentes, notebook o desktop): ");
	        		String categoria = leer.nextLine();
	        		
	        		System.out.println("Ingrese la cantidad del producto: ");
	        		String stock = leer.nextLine();
	        		
	        		insertInto.productos(nombre, marca, precio, categoria, stock);
	               break;
	               
	            case 2:
	               select.leerSelect();
	               break;
	               
	            case 3:
		           selectCategoria.leerSelect();
		               break;
	            case 4:
	            	selectUpdate.leerSelect();
	            	
	            	Scanner leerupdate = new Scanner(System.in);

	            	
	            	System.out.println("Escriba el Id de producto nuevamente: ");
	            	int newidproducto = Integer.parseInt(leerupdate.nextLine());
	            	
	            	System.out.println("Ingrese el nombre del producto: ");
	        		String newnombre = leerupdate.nextLine();
	        		
	        		System.out.println("Ingrese la marca del producto: ");
	        		String newmarca = leerupdate.nextLine();
	        		
	        		System.out.println("Ingrese el precio del producto: ");
	        		String newprecio = leerupdate.nextLine();
	        		
	        		System.out.println("Ingrese la categoria del producto (perifericos, componentes, notebook o desktop): ");
	        		String newcategoria = leerupdate.nextLine();
	        		
	        		System.out.println("Ingrese la cantidad del producto: ");
	        		String newstock = leerupdate.nextLine();
	        		
	        		update.productos(newidproducto, newnombre, newmarca, newprecio, newcategoria, newstock);
	            	
	        		System.out.println("\nEl producto con ID " + newidproducto + " fue modificado con exito!");

		               break;
	            case 5:
		           selectDelete.leerSelect();
		           
		           Scanner leerDelete = new Scanner(System.in);
		           
		           System.out.println("Si esta seguro de eliminiar  el registro escriba SI" + "\npara regresar al menu escriba NO");
		           String respuesta = leerDelete.nextLine();
		           
		           if (respuesta.equals("SI")) {
		        	   System.out.println("\nEscriba nuevamente el ID del producto: ");
		        	   int numeroproducto = Integer.parseInt(sn.nextLine());
		        	   delete.producto(numeroproducto);
		        	   
		        	   System.out.println("\nEl producto con ID " + numeroproducto + " se elimino con exito!");
		          } 

		               break;
		           
	            case 6:
	               salir=true;
	               break;
	               
	            default:   
	               System.out.println("Las opciones son entre 1 y 6");

	            }
	         }
	         catch(InputMismatchException | NumberFormatException e){
	            System.out.println("Debes seleccionar un numero de opcion");
	         }
	         
	         //Pausa en la ejecución del programa
	         System.out.println("\n\t\t---Pulse ENTER para continuar---");
	         sn.nextLine();
	      }

	      System.out.println("Gracias por utilizar nuestro sistema... " + "\n\n-Grupo # 2 Catalogo de productos-");
	      System.out.println("\nAngela Sanchez      3490 23 17306" + "\nWerner Monroy       3490 23 22521" + "\nFrancisco Marroquin 3490 23 9521" + "\nWagner Monroy       3490 23 22518");
	      sn.close();
	   }
	   
}