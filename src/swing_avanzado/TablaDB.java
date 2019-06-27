package swing_avanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class TablaDB {

	public static void main(String[] args) {
		JFrame mi_ventana=new VentanaTablaDB();
		mi_ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mi_ventana.setVisible(true);
	}
}
class VentanaTablaDB extends JFrame{
	private DatabaseMetaData mt;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private ModeloTabla modelo;
	JComboBox cmb_tablas;
	
	public VentanaTablaDB() {		
		setTitle("Tabla Personalizada");
		setBounds(200,200,800,400);
		JPanel panel_superior=new JPanel();
		cmb_tablas=new JComboBox();
		try {
			
			//CONECTAMOS CON LA DB PARA BUSCAR LAS TABLAS DE LA DB
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","fraga","adminfraga");
			mt=con.getMetaData();
			rs=mt.getTables("javadb", "javadb", null, null);
			//LLENAMOS EL COMBO
			while(rs.next()) {  
				cmb_tablas.addItem(rs.getString("TABLE_NAME"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//DEFINIMOS LA ACCION DEL COMBO
		cmb_tablas.addActionListener(new ActionListener() {  

			@Override
			public void actionPerformed(ActionEvent e) {  				
				String tabla_seleccionada=(String)cmb_tablas.getSelectedItem();
				//LEEMOS LA TABLA
				String query="SELECT * FROM " + tabla_seleccionada;
				try {
					st=con.createStatement();
					rs=st.executeQuery(query);
					modelo=new ModeloTabla(rs);		//le paso el resultset de los registros al modelo
					JTable mi_tabla=new JTable(modelo);   //creo la tabla de acuerdo al modelo
					add(new JScrollPane(mi_tabla), BorderLayout.CENTER);  //le agrego scroll panel a la tabla
					validate();  //es para que la pinte la tabla
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
		panel_superior.add(cmb_tablas);
		add(panel_superior, BorderLayout.NORTH);	
	}		
}

class ModeloTabla extends AbstractTableModel{

	private ResultSet rs_registros;
	private ResultSetMetaData rs_meta;
	
	public ModeloTabla(ResultSet rs) { //constructor
		rs_registros=rs;
		try {
			rs_meta=rs.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int getRowCount() { //saco el num de registros del rs llendo al ultimo
		try {
			rs_registros.last();		
			return rs_registros.getRow();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		
		try {
			return rs_meta.getColumnCount();  //saco las columnas del metada
		} catch (SQLException e) {			
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Object getValueAt(int x, int y) {
		try {
			rs_registros.absolute(x+1);
			return rs_registros.getObject(y+1);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public String getColumnName(int c) {
		try {
			return rs_meta.getColumnName(c+1);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}