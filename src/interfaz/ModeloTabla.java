package interfaz;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel{

	private boolean[] columnEditables = new boolean[] {
			false, false, false, false, false
	};
	
	public ModeloTabla(Object[][] datos, String[] nombresColumnas){
		super();
		setDataVector(datos, nombresColumnas);
	}
	
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
}
