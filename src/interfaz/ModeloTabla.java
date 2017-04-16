package interfaz;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Datos.DatoTabla;

/**
* Esta clase modela los datos en un JTable
* @author Bernardo
*/
public class ModeloTabla extends DefaultTableModel{

	private boolean[] columnEditables = new boolean[] {
			false, false, false, false, false
	};
	
	public ModeloTabla(Object[][] datos, String[] nombresColumnas){
		super();
		setDataVector(datos, nombresColumnas);
	}
	
	public ModeloTabla(ArrayList<? extends DatoTabla> datos){
		super();
		String[] columnas = datos.get(0).getNombresVariables();
		Object[][] valores = new Object[datos.size()][columnas.length];
		for(int i=0;i<datos.size();i++){
			Object[] val = datos.get(i).getValores();
			for(int j=0;j<columnas.length;j++)
				valores[i][j] = val[j];
		}
		setDataVector(valores, columnas);
	}
	
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
}
