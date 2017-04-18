package interfaz;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Datos.DatoTabla;

/**
 * Esta clase modela los datos en un JTable
 * @author Bernardo
 */
public class ModeloTabla extends DefaultTableModel{

	private Object[][] objetos;
	
	private boolean[] columnEditables = new boolean[] {
			false, false, false, false, false
	};

	public ModeloTabla(Object[][] datos, String[] nombresColumnas){
		super();
		this.objetos = datos;
		setDataVector(datos, nombresColumnas);
	}
	
	public Object[][] getDatos(){
		return objetos;
	}

	public ModeloTabla(ArrayList<? extends DatoTabla> datos){
		super();
		if(datos.size() > 0){
			String[] columnas = datos.get(0).getNombresVariables();
			Object[][] valores = new Object[datos.size()][columnas.length];
			for(int i=0;i<datos.size();i++){
				Object[] val = datos.get(i).getValores();
				for(int j=0;j<columnas.length;j++)
					valores[i][j] = val[j];
			}
			this.objetos = valores;
			setDataVector(valores, columnas);
		}
	}
	
	public Object[] getFila(int i){
		Object[] fila = null;
		if(objetos != null)
			fila = objetos[i];
		return fila;
	}

	public boolean isCellEditable(int row, int column) {
		if(column < columnEditables.length && column >= 0)
			return columnEditables[column];
		else
			return false;
	}
}
