package lineasDeTiempo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import eventos.Evento;
import excepciones.NoSeEncontroElEvento;
import fechas.Fecha;
import fechas.SortFecha;

public class LineaDeTiempo implements Serializable {
	
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Evento> linea ;
	
	public LineaDeTiempo() {
		this.linea = new ArrayList<Evento>();
	}

	public int cantidadDeEventos() {
		return linea.size();
	}

	public void agregarEvento(Evento evento) {
		this.linea.add(evento);
		Collections.sort(linea, new SortFecha() );
	}

	public void mostrarEventos() {
		for(  Evento i: linea)  	System.out.println( i.getNombre() );			
	}

	public String descricionDelEvento(String nombre) {
		for(  Evento i: linea)  if(  i.getNombre().equals(nombre)  ) return i.getDescripcion();
		throw new NoSeEncontroElEvento();
	}

	public ArrayList<Evento> getLineaDeEventos() {	
		return linea;
	}
	
	public int eliminarEvento(String nombre) {
		
		for(int i =0 ; i < linea.size() ; i ++ ) {
			if(  linea.get(i).getNombre().equals(nombre)   ) {
				System.out.println("Entre al if de eliminar evento y parece q encontro algo con el mismo nombre");
				linea.remove(i);
				return 0;
			}
		}
		return 1;
	}
	
	public int modificarEvento(String nombre ,String nombreImagen,String colorboton, int dia , int mes , int anio , String descripcion) {
		Fecha fecha = new Fecha(anio,mes,dia);
		Evento nuevoEvento = new Evento(nombre,fecha,descripcion);
		
		nuevoEvento.agregarFoto(nombreImagen);
		nuevoEvento.setColor(colorboton);
		for(  Evento i: linea) {
			if(  i.getNombre().equals(nombre)  ) {
				linea.remove(i);
				linea.add(nuevoEvento);
				Collections.sort(linea, new SortFecha() );
			return 1;
			}
			
		}
		return 0;
	}
	
	public Evento buscarEvento(String nombre) {
		for( Evento evento: linea)  if(  evento.getNombre().equals(nombre)  ) return evento;
		return null;
	}
	

}
