package Datos;
import java.io.Serializable;

public class Proveedor implements Serializable, DatoTabla{

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int telefono;
    private int celular;
    private String detalleProducto;
	
    public Proveedor(String nombre, String apellidoPaterno, String apellidoMaterno, int telefono, int celular, String detalleProducto) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.celular = celular;
        this.detalleProducto = detalleProducto;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) { this.apellidoPaterno = apellidoPaterno; }
    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) { this.apellidoMaterno = apellidoMaterno; }
    public int getTelefono() { return telefono; };
    public void setTelefono(int telefono) { this.telefono = telefono; };
    public int getCelular() { return celular; };
    public void setCelular(int celular) { this.celular = celular; };
    public String getDetalleProducto() { return detalleProducto; };
    public void setDetalleProducto(String detalleProducto) { this.detalleProducto = detalleProducto; }

	@Override
	public String[] getNombresVariables() {
		String[] nombres = {"Nombre", "Apellido Paterno", "Apellido Materno", "Telefono", "Celular", "Detalle Producto"};
		return nombres;
	}

	@Override
	public Object[] getValores() {
		Object[] valores = {nombre, apellidoPaterno, apellidoMaterno, telefono, celular, detalleProducto};
		return valores;
	}

	@Override
	public boolean compararValores(Object[] valores) {
		boolean iguales = true;
		Object[] vals = getValores();
		int i = 0;
		while(i < valores.length && iguales){
			iguales = vals[i].toString().equals(valores[i].toString());
			i++;
		}
		return iguales;
	}
}
