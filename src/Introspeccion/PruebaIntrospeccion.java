package Introspeccion;

import java.lang.reflect.*;
import java.util.Scanner;

public class PruebaIntrospeccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada =new Scanner(System.in);
		System.out.println("Introduce el nombre de la clase:");
		String nombre_clase;
		nombre_clase=entrada.next();
		
		//Imprimir clase y super clase
		try {
			Class cl=Class.forName(nombre_clase);
			Class supercl=cl.getSuperclass();
			System.out.println("Clase " + nombre_clase);
			if(supercl!=null && supercl!=Object.class) {
				System.out.println(" extends " + supercl.getName());
			}
			System.out.println();
			
			System.out.println("Constructores:");
			imprimirConstructores(cl);
			
			System.out.println();
			System.out.println("Metodos:");
			imprimirMetodos(cl);
			
			System.out.println();
			System.out.println("Campos:");
			imprimirCampos(cl);
					
			
		}catch(Exception e) {
			
		}
		
	}

	private static void imprimirCampos(Class cl) {
		Field[] campos=cl.getDeclaredFields();
		for(Field f:campos) {
			Class nomCampo=f.getType();
			String nombre=f.getName();
			System.out.print("  " + Modifier.toString(f.getModifiers()));
			System.out.print("  " + nomCampo.getName() + " " + nombre + ";\n");
		}
		
	}

	private static void imprimirMetodos(Class cl) {
		
		Method[] metodos=cl.getDeclaredMethods();
		
		for(Method m:metodos) {
			Class devuelto=m.getReturnType();
			String nombre=m.getName();
			System.out.print("  " + Modifier.toString(m.getModifiers()));
			System.out.print("  " + devuelto.getName() + " " + nombre + "(");
			//imprime los parametros
			Class[] tipoparam = m.getParameterTypes();
			for(int i=0;i<tipoparam.length; i++) {
				if(i>0) System.out.print(", ");
				System.out.print(tipoparam[i].getName());
			}
			System.out.print(");\n" );			
		}
	}

	private static void imprimirConstructores(Class cl) {
		
		Constructor[] constructores=cl.getDeclaredConstructors();
		
		for(Constructor c:constructores) {
			String nombre=c.getName();
			System.out.print("  " + Modifier.toString(c.getModifiers()));
			System.out.print("  " + nombre + "( " );
			//imprimir parametros
			Class[] tipoparam = c.getParameterTypes();
		
			for(int i=0;i<tipoparam.length; i++) {
				if(i>0) System.out.print(", ");
				System.out.print(tipoparam[i].getName());
			}
			
			System.out.print(");\n" );
		}		
	}

}
