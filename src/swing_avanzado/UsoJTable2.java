package swing_avanzado;
import javax.swing.*;
import javax.swing.table.*;

public class UsoJTable2 {
	public static void main(String[] args) {
		JFrame mi_ventana=new VentanaTablaPersonalizada();
		mi_ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mi_ventana.setVisible(true);
	}

}
class VentanaTablaPersonalizada extends JFrame{

	public VentanaTablaPersonalizada() {		
		setTitle("Tabla Personalizada");
		setBounds(200,200,600,600);
		TableModel mi_modelo=new ModeloTablaPersonalizada();
		JTable mi_tabla=new JTable(mi_modelo);
		add(new JScrollPane(mi_tabla));		
	}
}

class ModeloTablaPersonalizada extends AbstractTableModel{

	@Override
	public int getRowCount() {
		return 10;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int z=rowIndex+1;
		int y=columnIndex+2;
		
		return " " + z + " " + y;
	}
	
	public String getColumnName(int c) {
		return "Columna " + c;
	}
}