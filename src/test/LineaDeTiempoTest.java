package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import eventos.Evento;
import fechas.Fecha;
import lineasDeTiempo.LineaDeTiempo;

public class LineaDeTiempoTest {
	
	@Test
	public void creoLineaDeTiempoVacia() {
		LineaDeTiempo linea = new LineaDeTiempo();
		
		assertEquals(0, linea.cantidadDeEventos());
	}

	@Test
	public void agregoUnEventoEnMiLineaDeTiempo() {
		LineaDeTiempo linea = new LineaDeTiempo();
		Fecha fecha = new Fecha(0,12,24);
		Evento evento = new Evento("Nacimiento Jesus",fecha,"Comienzo");
		
		linea.agregarEvento(evento);
		
		assertEquals(1, linea.cantidadDeEventos());
	}
	
	@Test
	public void agregoMuchosEventoEnMiLineaDeTiempo() {
		LineaDeTiempo linea = new LineaDeTiempo();
		Fecha fecha = new Fecha(0,12,24);
		
		Evento evento = new Evento("Nacimiento Jesus",fecha,"Comienzo");
		
		for (int i = 0 ; i<5 ; i++) {
			linea.agregarEvento(evento);
		}
		
		assertEquals(5, linea.cantidadDeEventos());
	}
	
	@Test
	public void mostrarDeterminadoEventoEnMiLineaDeTiempo() {
		LineaDeTiempo linea = new LineaDeTiempo();	
		
		Evento evento = new Evento("Nacimiento Jesus", new Fecha(0,12,24) ,"Comienzo");
		linea.agregarEvento(evento);
		Evento evento1 = new Evento("Nacimiento Mio", new Fecha(1990,2,26) ,"Comienzo2");
		linea.agregarEvento(evento1);
		
		String Esperado = "Comienzo2";
		
		assertEquals( Esperado, linea.descricionDelEvento("Nacimiento Mio"));
	}
}
