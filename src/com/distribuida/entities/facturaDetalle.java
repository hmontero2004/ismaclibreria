package com.distribuida.entities;

public class facturaDetalle {

	private int idFacturaDetalle;
	private int cantidad;
	private float subtotal;
	private Factura factura;
	private Libro libro;
	
	public facturaDetalle () {    }
	
	public facturaDetalle(int idFacturaDetalle, int cantidad, float subtotal, int idFactura, int idLibro) {
	
		this.idFacturaDetalle = idFacturaDetalle;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		//this.idFactura = idFactura;
		//this.idLibro = idLibro;
	}

	public int getIdFacturaDetalle() {
		return idFacturaDetalle;
	}

	public void setIdFacturaDetalle(int idFacturaDetalle) {
		this.idFacturaDetalle = idFacturaDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}



	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "facturaDetalle [idFacturaDetalle=" + idFacturaDetalle + ", cantidad=" + cantidad + ", subtotal="
				+ subtotal + ", factura=" + factura + ", libro=" + libro + "]";
	}
	
	
	
}
