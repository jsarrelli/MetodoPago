package MediosPago;

import TiendaOnline.Carrito;

public class PayPal implements EstrategiaPago{
	
	protected String id;
	protected String contraseña;
	
	
	public PayPal(String id, String contraseña) {
		super();
		this.id = id;
		this.contraseña = contraseña;
	}


	@Override
	public void pagar(int monto,Carrito carrito) {
		System.out.println("$" + monto + " pagado con paypal");
		carrito.setMonto(carrito.getMonto()-monto);

		
	}

	
	

}
