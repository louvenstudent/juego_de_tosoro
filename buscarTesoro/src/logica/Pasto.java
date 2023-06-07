package logica;

import java.io.Serializable;

public class Pasto implements Serializable{
	public int x, y, tamano;
	public String direccion;
	
	public Pasto (int x, int y, int tamano) {
	
		this.x = x;
		this.y = y;
		this.tamano = tamano;
	}
}