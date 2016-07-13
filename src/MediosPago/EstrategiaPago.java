package MediosPago;

import TiendaOnline.Carrito;

public interface EstrategiaPago {
	
	public void pagar(int monto, Carrito carrito);
	
	

}
