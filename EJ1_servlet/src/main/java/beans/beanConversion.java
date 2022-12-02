package beans;

public class beanConversion {
	private String celsius;
	private String fahrenheit;
	public beanConversion(String temp, String tipo) {
		if (tipo == "celsius") {
			this.fahrenheit = String.format("%.1f",( Integer.valueOf(temp) * 1.8f) + 32);	// Calculo Cel-Fah
			this.celsius = temp;
		}else {
			this.celsius = String.format("%.1f", (( Integer.valueOf(temp) - 32) / 1.8f)); 	// Calculo Fah-celsius
			this.fahrenheit = temp;
		}
	}
	public String getCelsius() {
		return celsius;
	}
	public String getFahrenheit() {
		return fahrenheit;
	}
	
}
