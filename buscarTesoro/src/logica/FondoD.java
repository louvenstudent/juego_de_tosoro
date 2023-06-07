package logica;

import java.io.Serializable;

public class FondoD implements Serializable{
	public int x, y;
	public int ancho,alto;
	
	
	
	public FondoD (int x, int y,int ancho,int alto) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		
	}

}
