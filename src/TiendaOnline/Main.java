package TiendaOnline;

import MediosPago.PayPal;

public class Main {

	public static void main(String[] args) {
		Carrito carrito = new Carrito();
		
		Item item1 = new Item ("123", 99);
		Item item2 = new Item ("222", 109);
		
		carrito.agregarItems(item1);
		carrito.agregarItems(item2);
		
		System.out.println(carrito.getMonto());
		carrito.pagar(new PayPal ("1", "564"));	//paga con paypal
		//carrito.pagar(new TarjetaCredito ("12450397485", "Juanma Muñoz", "123", "12/20")); //paga con tarjeta
		
		System.out.println(carrito.getMonto());
		
	}

}
