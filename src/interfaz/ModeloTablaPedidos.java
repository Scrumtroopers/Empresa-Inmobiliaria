package interfaz;

import javax.swing.table.DefaultTableModel;

public class ModeloTablaPedidos extends DefaultTableModel{
	
	private boolean[] columnEditables = new boolean[] {
			false, false, false, false,false	};
	
	public ModeloTablaPedidos(Object[][] datos,String[] nombreColumnas){
		super();
		setDataVector(datos, nombreColumnas);
	}
	
	public boolean isCellEditable(int row, int column){
		return columnEditables[column];
	}

}
