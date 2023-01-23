package beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CarroCompra {
	HashMap<Integer, LineaPedido> mapa;
	
	public void aniadeLinea(LineaPedido l) {
		int clave = l.getItem().getId();
		if (mapa.get(clave) != null) {
			LineaPedido extraida = mapa.get(clave);
			int cantidad = extraida.getCantidad();
			cantidad++;
			extraida.setCantidad(cantidad);
			mapa.put(clave, extraida);
		}else {
			mapa.put(clave, l);
		}

	}
	public void borrarLinea(int idItem) {
		if (mapa.get(idItem) != null) {
			mapa.remove(idItem);
		}
	}
	public LineaPedido getLineaPedido(int idItem) {
		if (mapa.get(idItem) != null) {
			return mapa.get(idItem);
		}
		return null;
	}
	public ArrayList<LineaPedido> getLineasPedido() {
		ArrayList<LineaPedido> arr = new ArrayList<LineaPedido>();
		mapa.forEach((k,v) -> arr.add(v));
		if (arr.size() > 0) {
			return arr;
		}
		return null;
	}
	public double total() {
		double total = 0;
		for(Map.Entry<Integer, LineaPedido> entry : mapa.entrySet()) { 
		    LineaPedido l = entry.getValue();
		    total += l.getPedido().getTotal();
		} 
		return total;
	}
	
	public void removeAll() {
		mapa.clear();
	}
	
	public boolean vacio() {
		boolean result = true;
		if (mapa.size() > 0) {
			result = false;
		}
		return result;
	}
	
}
