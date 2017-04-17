package Datos;

import java.io.Serializable;
import java.util.Date;

public class Cotizacion implements Serializable, DatoTabla {
	private String codigoCot;
	private Date fecha;
	private Date fechaVenc;
	private long NIT;
	private String empresa;
	private Producto producto;
	private double valorUni;
	private int cantidad;
	
	private double tipoCambio;
	
	public Cotizacion(String codigoCot,Date fecha,Date fechaVenc,long NIT,String empresa,Producto producto,double valorUni,int cantidad, double tipoCambio){
		this.setCodigoCot(codigoCot);
		this.setFecha(fecha);
		this.setFechaVenc(fechaVenc);
		this.setNIT(NIT);
		this.setEmpresa(empresa);
		this.setProducto(producto);
		this.setValorUni(valorUni);
		this.setCantidad(cantidad);
		this.tipoCambio = tipoCambio;
	}
	
	public void setTipoCambio(double nuevo){
		this.tipoCambio = nuevo;
	}

	public String getCodigoCot() {
		return codigoCot;
	}

	public void setCodigoCot(String codigoCot) {
		this.codigoCot = codigoCot;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaVenc() {
		return fechaVenc;
	}

	public void setFechaVenc(Date fechaVenc) {
		this.fechaVenc = fechaVenc;
	}

	public long getNIT() {
		return NIT;
	}

	public void setNIT(long nIT) {
		NIT = nIT;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getValorUni() {
		return valorUni;
	}

	public void setValorUni(double valorUni) {
		this.valorUni = valorUni;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void setCodigo(String cod){
		this.codigoCot = cod;
	}
	
	/**
	 * importe total en moneda extranjera
	 */
	public double importeTotal(){
		return valorUni*cantidad;
	}
	
	/**
	 * importe total en bolivianos
	 * @param tipoCambio
	 */
	public double importeTotalBs(){
		double importe=0;
		if(tipoCambio!=0){
			importe=importeTotal()*tipoCambio;
		}
		return importe; 
	}
	
	public boolean equals(Cotizacion otra){
		return codigoCot.equals(otra.codigoCot);
	}

	@Override
	public String[] getNombresVariables() {
		String[] nombresColumnas = {"Codigo","Fecha","Fecha de Vencimiento","NIT","Empresa","Producto","Valor Unitario($us)","Cantidad","Importe Total Moneda Extranjera","Importe Total(Bs)"};
		return nombresColumnas;
	}

	/**
	 * retorna todos los datos de la cotizacion en un array
	 * @return - todos los datos de la cotizacion como Object[]
	 */
	@Override
	public Object[] getValores() {
		Object[] datos = new Object[]{codigoCot, fecha, fechaVenc, NIT, empresa, producto.toString(), valorUni, cantidad, importeTotal(), importeTotalBs()};
		return datos;
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
