package Datos;

import java.util.Date;

public class Compra {
	private int nro;
	private Date fecha;
	private long nit;
	private String empresa;
	private long numFactura;
	private String numDUI;
	private long numAutorizacion;
	private double importeTotal;
	private double importeNoCreditoFiscal;
	private double descuento;
	private String codigoControl;
	private int tipoCompra;
	
	public Compra(int nro,Date fecha,long nit,String empresa,long numFactura,String numDUI,long numAutorizacion,double importeTotal,double importeNoCreditoFiscal,double descuento,String codigoControl,int tipoCompra){
		this.nro=nro;
		this.fecha=fecha;
		this.nit=nit;
		this.empresa=empresa;
		this.numFactura=numFactura;
		this.numDUI=numDUI;
		this.numAutorizacion=numAutorizacion;
		this.importeTotal=importeTotal;
		this.importeNoCreditoFiscal=importeNoCreditoFiscal;
		this.descuento=descuento;
		this.codigoControl=codigoControl;
		this.tipoCompra=tipoCompra;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getNit() {
		return nit;
	}

	public void setNit(long nit) {
		this.nit = nit;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public long getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(long numFactura) {
		this.numFactura = numFactura;
	}

	public String getNumDUI() {
		return numDUI;
	}

	public void setNumDUI(String numDUI) {
		this.numDUI = numDUI;
	}

	public long getNumAutorizacion() {
		return numAutorizacion;
	}

	public void setNumAutorizacion(long numAutorizacion) {
		this.numAutorizacion = numAutorizacion;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public double getImporteNoCreditoFiscal() {
		return importeNoCreditoFiscal;
	}

	public void setImporteNoCreditoFiscal(double importeNoCreditoFiscal) {
		this.importeNoCreditoFiscal = importeNoCreditoFiscal;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public String getCodigoControl() {
		return codigoControl;
	}

	public void setCodigoControl(String codigoControl) {
		this.codigoControl = codigoControl;
	}

	public int getTipoCompra() {
		return tipoCompra;
	}

	public void setTipoCompra(int tipoCompra) {
		this.tipoCompra = tipoCompra;
	}
	
	public double getSubtotal(){
		return importeTotal-importeNoCreditoFiscal;
	}
	
	public double getImporteBase(){
		return getSubtotal()-descuento;
	}
	
	public double getCreditoFiscal(){
		return getImporteBase()*0.13;
	}
	
	public Object[] getDAtos(){
		Object[] datos = {nro,fecha,nit,empresa,numFactura,numDUI,numAutorizacion,importeTotal,importeNoCreditoFiscal,getSubtotal(),descuento,getImporteBase(),getCreditoFiscal(),codigoControl,tipoCompra};
		return datos;
	}
}
