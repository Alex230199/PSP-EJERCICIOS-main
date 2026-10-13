package ACT_HILO_2909;

import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
	
		Scanner teclado = new Scanner (System.in);
	
	System.out.println("Dame el nombre del primer alumno");
	String nombre1 = teclado.nextLine();
	//Alumno alumno1 = new Alumno(nombre1);
	Thread hilo1 = new Thread(new Alumno(nombre1), nombre1);
	
	System.out.println("Dame el nombre del primer alumno");
	String nombre2 = teclado.nextLine();
	//Alumno alumno2 = new Alumno(nombre2);
	Thread hilo2 = new Thread(new Alumno(nombre2), nombre2);
	
	System.out.println("Dame el nombre del primer alumno");
	String nombre3 = teclado.nextLine();
	Alumno alumno3 = new Alumno(nombre3);
	Thread hilo3 = new Thread(alumno3, nombre3);
	
	ejecutar(hilo1);
	ejecutar(hilo2);
	ejecutar(hilo3);
	}
	
	static void ejecutar(Thread hilo) {
	
		hilo.start();
		if (hilo.getName().length()<3) {
			System.err.println("El hilo no cumple con el criterio");
			hilo.interrupt();
		}
		
		try {
			hilo.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Todos los alumnos han terminado de ejecutarse");
		
	}
	
	/*
	hilo1.start();
	
	try {
		hilo1.join();
		
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	hilo2.start();
	
	try {
		hilo2.join();
		
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	
	hilo3.start();
	
	try {
		hilo3.join();
		
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	System.out.println("Todos los alumnos han terminado de ejecutarse");
	*/
	
	}

