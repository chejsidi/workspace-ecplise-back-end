package beans;

import java.util.ArrayList;

public class Test {
	private int numPreguntas;
	private ArrayList<String> preguntas;
	private static String[] arrPreg = {"Cuantas copas del mundo tiene messi?","Cuanto va a ser el proximo mundial?", "Mejor cilista colombiano?", "Quien gano el mundial?", "Cuantos años tiene Cristiano?"};
	
	public Test(int cant) {
		int num;
		String pregunta;
		if (cant < arrPreg.length) {
			num = (int) (Math.random() * arrPreg.length + 1);
			pregunta = arrPreg[num];
			while (preguntas.contains(pregunta)) {
				num = (int) (Math.random() * arrPreg.length + 1);
				pregunta = arrPreg[num];
			}
			preguntas.add(pregunta);
		}else {
			for(String preg: arrPreg) {
				preguntas.add(preg);
			}
		}
	}
	
	public int comprobar(ArrayList<Integer> nUserResp) {
		
	}
}
