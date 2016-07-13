package TiendaOnline;
import java.util.ArrayList;
import java.util.List;

import MediosPago.EstrategiaPago;
import Ventanas.SeleccionarPago;

public class Carrito {
	
	protected List<Item>items;
	protected float monto;

	public Carrito() {
		super();
		this.items = new ArrayList <>();
		this.monto=0;
	}
	
	public void agregarItems (Item item){
		items.add(item);
		monto+=item.precio;
	}
	
	public void eliminarItem(Item item){
		items.remove(item);
	}
	
	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	// saca el total de todos los items del carrito
	public int CalcularTotal(){
		int sumaTotal=0;
		for(Item item : items){
			sumaTotal+= item.getPrecio();
			
		}
		return sumaTotal;
		
	}
	
	
	  public void pagar(EstrategiaPago metodoPago){
		  new SeleccionarPago(this);
	        //int monto1 = CalcularTotal();
	      //  metodoPago.pagar(monto1,this);
	      
	    }
	
	

}
