package vista;
import java.io.Serializable;

import javax.swing.JFrame;

public class PruebaFrame extends JFrame implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	public PruebaFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1800,800);//10550,10550
		Lienzo lienzo= new Lienzo();
		lienzo.addKeyListener(lienzo);
		lienzo.setFocusable(true);
		add(lienzo);
		setVisible(true);
		lienzo.proyectar(true);
	}
	public static void main(String [] args) {
		new PruebaFrame();
	
	}
	

}
