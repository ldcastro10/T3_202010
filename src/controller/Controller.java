package controller;


import java.util.Scanner;

import model.Comparendo;
import model.data_structures.ILinkedList;
import model.data_structures.LinkedList;
import model.data_structures.Node;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	private ILinkedList<Comparendo> f;
	private Comparable<Comparendo>[] consulta;
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
		f = new LinkedList<Comparendo>();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";
		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
				    modelo = new Modelo();
					
				    long start = System.currentTimeMillis();
				   f =  modelo.cargarlinkedList();
				    long end = System.currentTimeMillis();
				    
				    view.printMessage("Tiempo de carga (seg): " + (end-start)/1000.0);
					view.printMessage("Datos cargados: " + f.getSize() + "\n");
			   view.printMessage("Primer dato: " + f.get(0).getObject() + "\n");
			 view.printMessage("Ultimo dato: " + (f.get(f.getSize() - 1 )).getObject() + "\n");
					
				
			//	        for( node = linkedList.get(0); node != null; node = node.getNext() )
				        

				   break;
					
				case 2:
					System.out.println("3. Ordenar consulta ascendentemente con ShellSort");
					if(consulta != null)
					{
						long tiempo = modelo.sortingBenchmarkOptionA(consulta,
								model.logic.Modelo.SHELLSORT );
						System.out.println("Primeros 10 comparendos");
						for(int i = 0; i <= 10 ;i++)
						{
							System.out.println("------------------------------------------------------------------------------------------------------------");
							System.out.println(consulta[i].toString());
							System.out.println("------------------------------------------------------------------------------------------------------------");

						}
						System.out.println("Últimos 10 comparendos");
						for(int i = consulta.length-1; i >= (consulta.length+10) ;i--)
						{
							System.out.println("------------------------------------------------------------------------------------------------------------");
							System.out.println(consulta[i].toString());
							System.out.println("------------------------------------------------------------------------------------------------------------");

						}
						System.out.println("El ordenamiento tomó "+tiempo+" milisegundos");
					
			}
			else
			{
				System.out.println("No se ha realizado la consulta");
			}
			break;
				case 3:
					System.out.println("4. Ordenar consulta ascendentemente usando MergeSort");
					if(consulta != null)
					{
						long tiempo = modelo.sortingBenchmarkOptionA(consulta,
								model.logic.Modelo.MERGESORT );
						System.out.println("Primeros 10 comparendos");
						for(int i = 0; i <= 10 ;i++)
						{
							System.out.println("------------------------------------------------------------------------------------------------------------");
							System.out.println(consulta[i].toString());
							System.out.println("------------------------------------------------------------------------------------------------------------");

						}
						System.out.println("Últimos 10 comparendos");
						for(int i = consulta.length-1; i >= (consulta.length+10) ;i--)
						{
							System.out.println("------------------------------------------------------------------------------------------------------------");
							System.out.println(consulta[i].toString());
							System.out.println("------------------------------------------------------------------------------------------------------------");

						}
						System.out.println("El ordenamiento tomó "+tiempo+" milisegundos");
					}
					else
					{
						System.out.println("No se ha realizado la consulta");
					}
					break;

				case 4: 
					System.out.println("5. Ordenar consulta ascendentemente usando QuickSort");
					if(consulta != null)
					{
						long tiempo = modelo.sortingBenchmarkOptionA(consulta,
								model.logic.Modelo.QUICKSORT );
						System.out.println("Primeros 10 comparendos");
						for(int i = 0; i <= 10 ;i++)
						{
							System.out.println("------------------------------------------------------------------------------------------------------------");
							System.out.println(consulta[i].toString());
							System.out.println("------------------------------------------------------------------------------------------------------------");
						}
						System.out.println("Últimos 10 comparendos");
						for(int i = consulta.length-1; i >= (consulta.length+10) ;i--)
						{
							System.out.println("------------------------------------------------------------------------------------------------------------");
							System.out.println(consulta[i].toString());
							System.out.println("------------------------------------------------------------------------------------------------------------");

						}
						System.out.println("El ordenamiento tomó "+tiempo+" milisegundos");
					}
					else
					{
						System.out.println("No se ha realizado la consulta");
					}
					break;	
		
			}
		}
		
	}	
}
