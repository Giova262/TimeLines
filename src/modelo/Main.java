package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import eventos.Evento;
import fechas.Fecha;
import lineasDeTiempo.LineaDeTiempo;
import persistencias.ArchivoLineasDeTiempo;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
			

	ArchivoLineasDeTiempo archivo = new ArchivoLineasDeTiempo();
	
		//LineaDeTiempo linea ;
		ArrayList <Evento> lista ;
		ArrayList <String> nombres = new ArrayList<String>();
		ArrayList <String> fotos = new ArrayList<String>();
		ArrayList <String> descripciones = new ArrayList<String>();
		ArrayList <Fecha> fechas = new ArrayList<Fecha>();
		
		ArrayList <String> temporal ;
		ArrayList <String> temporal2 ;
		ArrayList <String> temporal3 ;
		ArrayList <Fecha> temporal4;
		
		temporal = archivo.recuperar2("nombres.obj");
		temporal2 = archivo.recuperar2("descripciones.obj");
		temporal3 = archivo.recuperar2("fotos.obj");
		temporal4 = archivo.recuperar3("fechas.obj");
		
		LineaDeTiempo linea = new LineaDeTiempo();
		
		for (int i = 0 ; i < temporal.size() ; i ++) {
			Evento nuevo = new Evento( temporal.get(i) , temporal4.get(i) , temporal2.get(i) );
			nuevo.agregarFoto(temporal3.get(i));
			linea.agregarEvento(nuevo);
		}
		
		archivo.guardar(linea, "Biblia2.obj");
	
	/*	linea = archivo.recuperar("Biblia.obj");
		lista = linea.getLineaDeEventos();
			
		for (int i = 0 ; i < lista.size() ; i ++) {
			nombres.add( lista.get(i).getNombre()  ) ;
			fechas.add(  lista.get(i).getFecha()  ) ;
			descripciones.add( lista.get(i).getDescripcion() );
			fotos.add(lista.get(i).getFoto());			
		}
		
		archivo.guardarArrayString(nombres, "nombres.obj");
		archivo.guardarArrayString(descripciones, "descripciones.obj");
		archivo.guardarArrayString(fotos, "fotos.obj");
		archivo.guardarFechas(fechas, "fechas.obj");*/
		
		/*for ( Fecha i: temporal4) {
			System.out.println(i.getFormatoFecha());
		}
		*/
		//archivo.guardarArrayString(nombres, "nombres.obj");

	}

}
