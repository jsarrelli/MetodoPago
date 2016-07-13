package TiendaOnline;

public class Item {
	
	protected String codigo;
	protected int precio;
	
	public Item(String codigo, int precio) {
		super();
		this.codigo = codigo;
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
	

}
