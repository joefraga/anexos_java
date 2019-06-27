package swing_avanzado;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.*;

public class PruebaLista {

	public static void main(String[] args) {
		JFrame mi_ventana=new MarcodeLista();
		mi_ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mi_ventana.setVisible(true);		

	}
}

class MarcodeLista extends JFrame{
	private JList<String> lista_meses;	
	private JPanel laminaLista,laminatexto;
	private JLabel rotulo;
	
	public MarcodeLista() {
		setTitle("Prueba de Lista");
		setBounds(400,300,400,400);
		String meses[]= {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
				"Julio", "Agosto", "Septiembre","Octubre", "Noviembre", "Diciembre"};
		
		lista_meses=new JList<String>(meses);
		lista_meses.setVisibleRowCount(5);
		JScrollPane lamina_desplazamiento=new JScrollPane(lista_meses);
		laminaLista=new JPanel();	
		laminaLista.add(lamina_desplazamiento);
		
		lista_meses.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				List<String> lista_valores=lista_meses.getSelectedValuesList();
				StringBuilder texto =new StringBuilder("Mes seleccionado: ");
				
				for(String s: lista_valores) {
					String palabra=s;
					texto.append(palabra);
					texto.append(" ");
					
				}
				rotulo.setText(texto.toString());
			}			
			
		});
		laminatexto=new JPanel();
		rotulo=new JLabel("Mes seleccionado: ");
		laminatexto.add(rotulo);
		
		add(laminaLista, BorderLayout.NORTH);
		add(laminatexto,BorderLayout.SOUTH);
	}
	
}