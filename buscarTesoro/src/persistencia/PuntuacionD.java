package persistencia;

import java.io.Serializable;



public class PuntuacionD implements Serializable{
	//public int x,y;
	public int Nivel;
	public String Mensage;
	 
	
	public PuntuacionD (int Nivel,String Mensage ) {
		
		this.Nivel = Nivel;
		this.Mensage="ＢＵＳＣＡ ＬＡ ＭＯＮＥＤＡ";
		
		//p1.x=p1.x;
		//p1.y=p1.y;
	}



	
	

}
/*  NOTA QUE EL GUARDAR Y CARGAR ESTA EN EL LINZO LIÑA 127 Y TERMINA EN LA LIÑA 170
 * y EN LA CLASE SUBRECOMPENSA CUANDO DETECTA LA COLICION  ESO ES TODO LA PERCISTECIA 
 * Y EN LA POSICION X = 300 Y = 100 SE PUEDE COLICIONAR  
 * 
 * LOS INTEGRANTES SON LOUVENDY STERLING : CAMILO GARCES :NICOLAS FERNANDEZ*/
 