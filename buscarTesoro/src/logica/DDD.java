package logica;

import java.io.Serializable;

public class DDD implements Serializable {
	public int x, y, tamano;
	public String direccion;
	
	public DDD (int x, int y, int tamano) {
	
		this.x = x;
		this.y = y;
		this.tamano = tamano;
	}

}
