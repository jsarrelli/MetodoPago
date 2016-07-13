package MediosPago;

import TiendaOnline.Carrito;

public class TarjetaCredito implements EstrategiaPago{

	protected String numeroTarjeta;
	protected String nombreTitular;
	protected String codigoTarjeta;
	protected String fechaVencimiento;
	
	
	public TarjetaCredito(String numeroTarjeta, String nombreTitular, String codigoTarjeta, String fechaVencimiento) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.nombreTitular = nombreTitular;
		this.codigoTarjeta = codigoTarjeta;
		this.fechaVencimiento = fechaVencimiento;
	}


	public void pagar(int monto,Carrito carrito) {
		
	System.out.println("$" + monto + " pagado con credito/debito");
	carrito.setMonto(carrito.getMonto()-monto);
		
		
	}
	
	

}
