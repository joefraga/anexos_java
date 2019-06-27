package Introspeccion;

public class UsoEmpleado {

	public static void main(String[] args) {
		Persona antonio=new Persona("Antonio");
		System.out.println(antonio.getNombre());
		Empleado ana=new Empleado("Ana", 2000);
		System.out.println(ana.getNombre() + " " + ana.getSalario());
		
		System.out.println(antonio.getClass());
		
		//Class cl1=antonio.getClass();
				
		String nombre_clase="Introspeccion.Empleado";
		
		try {
			Class cl1 = Class.forName(nombre_clase);
			System.out.println(cl1.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

class Persona{
	private String nombre;
	public Persona(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}	
}

class Empleado extends Persona{
	private double salario;
	Empleado(String nombre, double salario){
		super(nombre);
		this.salario=salario;
	}
	
	public void Incentivo(double incentivo) {
		salario=salario+incentivo;
	}
	
	public double getSalario() {
		return salario;
	}
}