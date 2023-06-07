 package logica;

import java.io.Serializable;

import persistencia.PuntuacionD;

public class Subrecompensa implements Serializable{
	public int x2, y2;
	public int ancho,alto;
	
	public Subrecompensa (int x2, int y2,int ancho,int alto) {
		super();
		this.x2 = x2;
		this.y2 = y2;
		this.ancho = ancho;
		this.alto = alto;
		
	}
	public boolean detectarColision(Personaje p, PuntuacionD l) {
		if(p.x==this.x2 || p.y==this.y2|| (p.x==ancho|| p.y==alto)
			/*|| (p.x==ancho|| p.y==alto) ){*/
		||(p.x+58)==this.x2 || (this.x2+this.ancho)==p.y+116) {
			//ancho=0;
			// alto=0;
			this.x2=(Integer) null;
			this.y2=(Integer) null;
			l.Nivel=+1;
			l.Mensage="GANASTE LA CASA";
			//JOptionPane.showMessageDialog(null,"Ganaste el juego");
			return true;
		}
		else
			return false;
		
	}


}
