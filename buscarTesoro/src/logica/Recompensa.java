package logica;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class Recompensa implements Serializable {
	public int x, y, tamano;
	public String direccion;
	
	public Recompensa (int x, int y, int tamano) {
	
		this.x = x;
		this.y = y;
		this.tamano = tamano;
		
	}
}