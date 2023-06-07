package vista;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logica.DDD;
import logica.FondoD;
import logica.Pasto;
import logica.Personaje;
import logica.Recompensa;
import logica.Subrecompensa;
import persistencia.PuntuacionD;

public class Lienzo extends JPanel implements KeyListener, Serializable {
	public void proyectar(boolean c) {
		// TODO Auto-generated method stub
		if (c==true) {
			p1.direccion="izquierda1";
			nombre=JOptionPane.showInputDialog("Ingrese su nombre porfavor");
                        mensajeIn= true;
			JOptionPane.showMessageDialog(null,"¡BIENVENIDO AMIG@! "+nombre+"\n"
					+ "¡El juego consiste en buscar el anhelado tesoro!\r\n"
					+ "El personaje tiene muchas distracciones en el camino hacia la meta. Se inteligente, ¡tú puedes lograrlo!\r\n"
					+ "\r\n"
					+ "Tienes exactamente 50 s. para hallar el tesoro.\r\n"
					+ "\r\n"
					+ "En la parte de izquierda de arriba encontrarás las indicaciones de la juagada,\n y presionando la tecla “G” podrás guardar el avance en caso de pausar el juego. Con la tecla “H” podrás volver a jugar.\n Por último, con “Esc” puedes retirarte del juego.\r\n"
					+ "\r\n"
					+ "¡Concéntrate!go.");
			marcha = true;
		}
		
	}
 
	
	private static final long serialVersionUID =1L;
	
	String nombre="";
	int Alto_personaje =0;
	int Hancho_personaje=0;
	int Q = 50;
	int P = 1404;
	boolean marcha = false;
	boolean projectar = false;
	boolean mensajes2 =false;
	boolean mensajeIn=false;

	
	Personaje p1 = new Personaje(Q,P,50);//30 ,20
	Recompensa r1 = new Recompensa(600,200,100);//30,20,5

	Subrecompensa su1= new Subrecompensa(300, 114, 30, 30);
	Pasto T = new Pasto(700,440,100);
	FondoD F= new FondoD (500,200,281,235);
	DDD s= new DDD(630,150,100);
	PuntuacionD B = new PuntuacionD( 0,null);//0,"BUSCA LA MONEDA",p1.x,p1.y
	Timer timer= new Timer();
	//String K = String.format("%1$5.3f", timer);
	
	TimerTask tarea =new TimerTask () {
		public void run () {
			if( B.Nivel==0) {
				B.Mensage="Perdiste se a agotado el tiempo";
				JOptionPane.showMessageDialog(null,"perdiste se ha agotado el tiempo");
			}
		}
	};

	//JOptionPane.showMessageDialog( 
	protected void paintComponent(Graphics g) {
		
		BufferedImage c,i,I,d,r,R,b,bb,m,f,u,D,o,d3,A,d1,x,a;	
		try {
			i= ImageIO.read(new File("src/movimientoP1/izquierda2.png"));// D:/juego_java/juego1/Juego_de_tresoro/buscarTesoro/
			I=ImageIO.read(new File("src/movimientoP1//izquierda3.png"));
			d= ImageIO.read(new File("src/movimientoP1/derecha2.png"));
			d3= ImageIO.read(new File("src/movimientoP1/derecha3.png"));
			d1=  ImageIO.read(new File("src/movimientoP1/izquierda1.png"));
			r= ImageIO.read(new File("src/movimientoP1/adelante2.png"));
			R= ImageIO.read(new File("src/movimientoP1/adelante3.png"));
			b= ImageIO.read(new File("src/movimientoP1/atras2.png"));
			bb= ImageIO.read(new File("src/movimientoP1/atras3.png"));
			c = ImageIO.read(new File("src/movimientoP1/lacasa.png"));
			m= ImageIO.read(new File("src/movimientoP1/arbolll.png"));
			a= ImageIO.read(new File("src/movimientoP1/monedaD.png"));
			x= ImageIO.read(new File("src/movimientoP1/recom.png"));
			f= ImageIO.read(new File("src/movimientoP1/pasto.png"));
			u= ImageIO.read(new File("src/movimientoP1/arbol.png"));
			D=ImageIO.read(new File("src/movimientoP1/felicidad.png"));
			o=ImageIO.read(new File("src/movimientoP1/atras1.png"));
			A=ImageIO.read(new File("src/movimientoP1/pergamino_de_instruciones.png"));//"src/movimientoP1/tierra.png"
			g.setColor(Color.lightGray);
			g.fillRect(0, 0, 1550, 800);
			g.drawImage(f,T.x,T.y,this);
			g.drawImage(x, su1.x2, su1.y2, su1.alto, su1.ancho,null);
			g.drawImage(a, su1.x2, su1.y2, su1.alto, su1.ancho,null);
			
			
			g.drawImage(x,500,500,null);
			g.drawImage(x,800,200,null);
			g.drawImage(x,1000,400,null);
			g.drawImage(x,1200,600,null);
			g.drawImage(x,720,600,null);
			
			
			g.setColor(Color.BLUE);
			g.drawString("𝑨𝑯𝑶𝑹𝑨 𝑬𝑺𝑻𝑨𝑺 𝑬𝑵 𝑵𝑰𝑽𝑬𝑳---: "+ B.Nivel,10 , 20);
			System.out.println("AHORA ESTAS EN NIVEL --->"+ B.Nivel);
			g.drawString("𝑴𝑬𝑵𝑺𝑨𝑮𝑬𝑺 ---: "+ B.Mensage,30 , 40);
			g.drawString("𝑼𝑩𝑰𝑪𝑨𝑪𝑰𝑶𝑵 ---: X :"+ p1.x,50 , 60);
			g.drawString("y :"+p1.y,200 , 60);
			
			
		
			if(p1.direccion.equals("Derecha")) 
				g.drawImage(d,p1.x, p1.y, this);
			if(p1.direccion.equals("Derecha2")) 
				g.drawImage(d3,p1.x, p1.y, this);
			if(p1.direccion.equals("izquierda1")) 
				g.drawImage(d1,p1.x, p1.y, this);
			if(p1.direccion.equals("Izquierda"))                       
				g.drawImage(i,p1.x, p1.y, this);
			if(p1.direccion.equals("Izquierda2"))
				g.drawImage(I,p1.x, p1.y, this);
			if(p1.direccion.equals("Arriba"))
				g.drawImage(r,p1.x, p1.y, this);
			if(p1.direccion.equals("Arriba2"))
				g.drawImage(R,p1.x, p1.y, this);
			if(p1.direccion.equals("Abajo"))
				g.drawImage(b,p1.x, p1.y, this);
			if(p1.direccion.equals("Abajo2"))
				//g.drawImage(bb,p1.x, p1.y, this);
				g.drawImage(bb,p1.x , p1.y, getFocusCycleRootAncestor());
			if(p1.direccion.equals("Quieto"))
				g.drawImage(o,p1.x, p1.y, this);
			if(su1.detectarColision(p1, B)) {	
				/*System.out.println ("Ganaste la casa");
				g.drawString("Ganaste la casa", 400, 100);*/
				g.drawImage(D, s.x, s.y, this);
			}
			g.drawImage(m,1001,270,null);
			g.drawImage(u,F.x,F.y,this);
			g.drawImage(c, r1.x, r1.y, this);
					
		} catch (IOException e) {
			System.out.println("ERROR - no se ha encontrado ...");
			e.printStackTrace();	
		}
		
	}
	//
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		// TODO Auto-generated method stub
		if(e.getKeyCode()==68) {//68
			p1.MoverDerecha();
			p1.direccion="Derecha2";
		}
		
		if(e.getKeyCode()==65) {
			p1.MoverIzquierda();
			p1.direccion="Izquierda2";
		}
		if(e.getKeyCode()==87) {
			p1.MoverArriba();
			p1.direccion="Arriba2";
		}
		if(e.getKeyCode()==83) {
			p1.MoverAbajo();
			p1.direccion="Abajo2";
			
		}
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("se presiono una tecla"+e);
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) { // Tecla ESC
			System.exit(0);// Cerrar juego
		}
		//double remainingTime= System.nanoTime();
		
		// eventos de movimiento
		if(e.getKeyCode()==68) {
			p1.MoverDerecha();
			p1.direccion="Derecha";	
		}
		//
		if(e.getKeyCode()==65) {
			p1.MoverIzquierda();
			p1.direccion="Izquierda";
		}
		if(e.getKeyCode()==87) {
			p1.MoverArriba();
			p1.direccion="Arriba";
		}
		if(e.getKeyCode()==83) {
			p1.MoverAbajo();
			p1.direccion="Abajo";
		}
		
		//guardar el juego con la tecla "G"
		if(e.getKeyCode()==71) {
			try {
				this.guardar();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		// iniciamos el juego con el "H"
		if(e.getKeyCode()==72) {
			p1.direccion="Quieto";
			try {
				
				B=cargar();
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
		}
		repaint();	
		if(marcha == true)
		timer.schedule(tarea, 60000);
	}	
	
	//AQUI GUARDAMOS LO QUE CONTIENE EL LINEZO
	public void guardar() throws Exception{
		/* guarda el curso en un archivo */
			FileOutputStream fos = new FileOutputStream("archivo.hola");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(B);
		    oos.close();
		    System.out.println("Funcionó guardar ");
	}
	//AQUI CARGAMOS LO QUE CONTIENE EL LINEZO
	public  PuntuacionD cargar() throws Exception {
		//recibe desde el archivo el curso guardado
		FileInputStream fis = new FileInputStream("archivo.hola");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    PuntuacionD c1; 
	    c1 = (PuntuacionD)ois.readObject();
	   // PuntuacionD.mostrar();
	    System.out.println("Funcionó cargar ");
	    ois.close();
	    return c1;
	 }

	
}
