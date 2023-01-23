package beans;

public class LineaPedido {
	private int id, cantidad;
	private Item item;
	private Pedido pedido;
	
	public LineaPedido() {
		// TODO Auto-generated constructor stub
	}

	public Item getItem() {
		return item;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public int getId() {
		return id;
	}
	

}
