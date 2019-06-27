package swing_avanzado;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class PruebaArbol {

	public static void main(String[] args) {		
		JFrame mi_ventana=new VentanaArbol();
		mi_ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mi_ventana.setVisible(true);	
		
	}
}
class VentanaArbol extends JFrame{
	
	public VentanaArbol() {
		setTitle("Prueba de Arbol");
		setBounds(400,300,200,200);
		System.out.println("entra1");
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Mundo"); 
		DefaultMutableTreeNode pais;
		DefaultMutableTreeNode estado;
		DefaultMutableTreeNode ciudad;
		
		pais=new DefaultMutableTreeNode("Mexico");
		raiz.add(pais);
				
		estado=new DefaultMutableTreeNode("Michoacan");
		pais.add(estado);
		
		ciudad=new DefaultMutableTreeNode("Morelia");
		estado.add(ciudad);
		ciudad=new DefaultMutableTreeNode("Uruapan");		
		estado.add(ciudad);
		
		estado=new DefaultMutableTreeNode("Guanajuato");
		pais.add(estado);
		estado=new DefaultMutableTreeNode("Jalisco");
		pais.add(estado);
		estado=new DefaultMutableTreeNode("Sinaloa");
		pais.add(estado);
		
		
		
		pais=new DefaultMutableTreeNode("USA");
		raiz.add(pais);
		estado=new DefaultMutableTreeNode("Michigan");
		pais.add(estado);
		
		estado=new DefaultMutableTreeNode("California");
		pais.add(estado);
		ciudad=new DefaultMutableTreeNode("Los Angeles");
		estado.add(ciudad);
		ciudad=new DefaultMutableTreeNode("San Diego");
		estado.add(ciudad);
		
		estado=new DefaultMutableTreeNode("Texas");
		pais.add(estado);
		estado=new DefaultMutableTreeNode("Nuevo Mexico");
		pais.add(estado);
		
		JTree arbol=new JTree(raiz);
		//Lamina_Arbol lamina=new Lamina_Arbol(arbol);
		//add(lamina);
		Container lamina_contenido=getContentPane();
		lamina_contenido.add(new JScrollPane(arbol));
				
	}
}

class Lamina_Arbol extends JPanel{
	
	public Lamina_Arbol(JTree arbol) {
		
		setLayout(new BorderLayout());
		
		add(arbol, BorderLayout.NORTH);
	}
}