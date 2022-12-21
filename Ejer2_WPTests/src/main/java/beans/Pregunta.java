package beans;

public class Pregunta {
	private String enunciado, pista;
	private int numPosCorrecta;
	private String[] respuestas;
	
	public Pregunta(String enunciado, String pista, int numPosCorrecta, String[] respuestas) {
		this.enunciado = enunciado;
		this.pista = pista;
		this.numPosCorrecta = numPosCorrecta;
		this.respuestas = respuestas;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getPista() {
		return pista;
	}

	public void setPista(String pista) {
		this.pista = pista;
	}

	public int getNumPosCorrecta() {
		return numPosCorrecta;
	}

	public void setNumPosCorrecta(int numPosCorrecta) {
		this.numPosCorrecta = numPosCorrecta;
	}

	public String[] getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(String[] respuestas) {
		this.respuestas = respuestas;
	}
	
	
	
}
