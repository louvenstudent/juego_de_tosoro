package logica;

import java.io.Serializable;

public class Personaje implements Serializable {
	public int x, y, tam;
	public String direccion;
	
	
	
	public Personaje ( int tam, int x, int y) {
		super();
		
		this.tam = tam;
		this.x=x ;
		this.y=y;
	}
	

	public void MoverArriba() {
		if (y>0 && y<=800)
		y=y-8;
	}
	
	public void MoverAbajo() {
		if( y<=710  ) 
		y=y+8;
	}
	public void MoverIzquierda() {
		if(x>0 && x<=1550)
			x=x-8;
		else
			x=0;
	}
	
	public void MoverDerecha() {
		if(x<1468)
			x=x+8;
		if (x>1472)
			x=0;
	}
		

}
