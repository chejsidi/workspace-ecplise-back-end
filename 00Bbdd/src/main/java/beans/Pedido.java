package beans;

import java.util.Date;

public class Pedido {
	private int id;
	private double total;
	private Date fechaPedido;
	private Cliente cliente;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public double getTotal() {
		return total;
	}

	public int getId() {
		return id;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
}
