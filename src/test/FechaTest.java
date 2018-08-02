package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

import excepciones.FechaIncorrectaError;
import fechas.Fecha;

public class FechaTest {

	
	// Mayor
	@Test
	public void fecha1esmayoralafecha2poraño() {
		Fecha fecha1 = new Fecha(1990,10,26);
		Fecha fecha2 = new Fecha(1900,10,26);
		
		assertEquals(1, fecha1.comparadaCon(fecha2) );
	}
	
	@Test
	public void fecha1esmayoralafecha2pormes() {
		Fecha fecha1 = new Fecha(1900,12,26);
		Fecha fecha2 = new Fecha(1900,10,26);
		
		assertEquals(1, fecha1.comparadaCon(fecha2) );
	}
	
	@Test
	public void fecha1esmayoralafecha2pordia() {
		Fecha fecha1 = new Fecha(1900,12,26);
		Fecha fecha2 = new Fecha(1900,12,2);
		
		assertEquals(1, fecha1.comparadaCon(fecha2) );
	}
	
	// Menor	
	@Test
	public void fecha1esmenoralafecha2poraño() {
		Fecha fecha1 = new Fecha(1900,10,26);
		Fecha fecha2 = new Fecha(1990,10,26);
		
		assertEquals(-1, fecha1.comparadaCon(fecha2) );
	}
	
	@Test
	public void fecha1esmenoralafecha2pormes() {
		Fecha fecha1 = new Fecha(1900,1,26);
		Fecha fecha2 = new Fecha(1900,2,26);
		
		assertEquals(-1, fecha1.comparadaCon(fecha2) );
	}
	
	@Test
	public void fecha1esmenoralafecha2pordia() {
		Fecha fecha1 = new Fecha(1900,10,2);
		Fecha fecha2 = new Fecha(1900,10,26);
		
		assertEquals(-1, fecha1.comparadaCon(fecha2) );
	}
	
	// Igual
	@Test
	public void fecha1esigualalafecha2poraño() {
		Fecha fecha1 = new Fecha(1990,10,26);
		Fecha fecha2 = new Fecha(1990,10,26);
		
		assertEquals(0, fecha1.comparadaCon(fecha2) );
	}
	
	//fecha incorrecta
	@Test
	public void fechaincorrectasaltaexcepcion() {
		boolean lanzar = false;
		
		try {
			
			@SuppressWarnings("unused")
			Fecha fecha = new Fecha(-1990,10,50);
			
		}catch (FechaIncorrectaError e) {
			lanzar = true;
		}
	
		assertTrue(lanzar);
	}
	
	
}
