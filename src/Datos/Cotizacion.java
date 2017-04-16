package Datos;

import java.util.Date;

public class Cotizacion {
	private String codigoCot;
	private Date fecha;
	private Date fechaVenc;
	private long NIT;
	private String empresa;
	private Producto producto;
	private double valorUni;
	private int cantidad;
	
	public Cotizacion(String codigoCot,Date fecha,Date fechaVenc,long NIT,String empresa,Producto producto,double valorUni,int cantidad){
		this.setCodigoCot(codigoCot);
		this.setFecha(fecha);
		this.setFechaVenc(fechaVenc);
		this.setNIT(NIT);
		this.setEmpresa(empresa);
		this.setProducto(producto);
		this.setValorUni(valorUni);
		this.setCantidad(cantidad);
	
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
	
	private int getCantidad() {
		return cantidad;
	}

	private void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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
	public double importeTotalBs(double tipoCambio){
		double importe=0;
		if(tipoCambio!=0){
			importe=importeTotal()*tipoCambio;
		}
		return importe; 
	}
	
	/**
	 * retorna todos los datos de la cotizacion en un array
	 * @param tipoCambio - tipo de cambio de moneda extranjera
	 * @return - todos los datos de la cotizacion como Object[]
	 */
	public Object[] getDatos(double tipoCambio){
		Object[] datos = new String[10];
		datos[0]=codigoCot;
		datos[1]=fecha;
		datos[2]=fechaVenc;
		datos[3]=NIT;
		datos[4]=empresa;
		datos[5]=producto.getNombre();
		datos[6]=valorUni;
		datos[7]=cantidad;
		datos[8]=importeTotal();
		datos[9]=importeTotalBs(tipoCambio);
		return datos;
	}
	
	public boolean equals(Cotizacion otra){
		return codigoCot.equals(otra.codigoCot);
	}
	
	

}
