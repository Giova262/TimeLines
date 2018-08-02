package fechas;

import java.io.Serializable;

import excepciones.FechaIncorrectaError;

public class Fecha  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int anio;
	private int mes ;
	private int dia;
	
	public Fecha(int anio, int mes, int dia) {
		this.anio = anio;
		this.mes = mes;
		this.dia = dia;
		this.verificacionDeDatos();
	}

	private void verificacionDeDatos() {
		if(  mes < 1  ||  mes > 12 ) 	throw new FechaIncorrectaError(); 		
		if(  dia < 1 ||  dia > 31 )  throw new FechaIncorrectaError(); 				
	}

	public int getAnio() {
		return anio;
	}

	public int getMes() {
		return mes;
	}

	public int getDia() {
		return dia;
	}

	public int comparadaCon(Fecha fecha) {
		
		if( anio <  fecha.getAnio() )  return -1;
		else if ( anio == fecha.getAnio() ) {			
				if( mes < fecha.getMes() )  return -1;	
				else if( mes == getMes() ) {			
					if( dia < fecha.getDia()) return -1;
				}			
		}
		
		if( anio >  fecha.getAnio() )  return 1;
		else if ( anio == fecha.getAnio() ) {			
				if( mes > fecha.getMes() )  return 1;	
				else if( mes == getMes() ) {			
					if( dia > fecha.getDia()) return 1;
				}			
		}
		return 0;
	}

	public String getFormatoFecha() {
		String formato = Integer.toString(dia) + "/"+ Integer.toString(mes) + "/"+ Integer.toString(anio) ;
		return formato;
	}



	

}
