package beans;

public class Cuenta {
	private String titular;
	private int saldo;
	
	
	public boolean gastar(int cantidad) {
		if ((this.saldo - cantidad) > 0) {
			this.saldo -= cantidad;
			return true;
		}else {
			return false;
		}
		
	}
	public void ingresar(int cantidad) {
		this.saldo += cantidad;
	}
	
}
