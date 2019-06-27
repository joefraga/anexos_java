package swing_avanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UsoJTable {

	public static void main(String[] args) {
		JFrame mi_ventana=new VentanaTabla();
		mi_ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mi_ventana.setVisible(true);

	}

}
class VentanaTabla extends JFrame{
	
	private String[] nombreColumnas = {"Nombre", "Radio", "Lunas", "Gaseoso"};
	private Object[][] datosfila= {
			{"Mercurio",2440,0,"no"},
			{"Venus",6052,0,"no"},
			{"Tierra",6378,1,"no"},
			{"Marte",3397,2,"no"},
			{"Jupiter",71492,16,"si"},
			{"Saturno",60268,18,"si"},
			{"Urano",25559,17,"si"},
			{"Neptuno",24766,8,"si"},
			{"Pluton",1137,1,"no"}
	};
	
	public VentanaTabla() {
		
		setTitle("Tabla de Planetas");
		setBounds(200,200,600,600);
		JTable tablaPlanetas=new JTable(datosfila, nombreColumnas);
		add(new JScrollPane(tablaPlanetas), BorderLayout.NORTH);
		JButton btn_imprimir=new JButton("Imprimir Tabla");
		btn_imprimir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tablaPlanetas.print();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		JPanel laminaBoton=new JPanel();
		laminaBoton.add(btn_imprimir);
		add(laminaBoton, BorderLayout.SOUTH);
		
	}
}