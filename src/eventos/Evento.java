package eventos;

import java.io.Serializable;

import fechas.Fecha;

public class Evento implements Serializable{
	
	private String nombre;
	private Fecha fecha;
	private String descripcion;
	private String foto;

	
	public Evento(String nombre, Fecha fecha, String descripcion) {		
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.foto = "defecto.jpg";
	}

	public Fecha getFecha() {
		return this.fecha;
	}
	
	public String getFoto() {
		return this.foto;
	}

	public String getNombre() {		
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public int compararloCon(Evento o2) {	
		return fecha.comparadaCon(o2.getFecha());
	}
	
	public void agregarFoto(String foto ) {
		this.foto = foto;
	}

	public String getFechaString() {
		return this.fecha.getFormatoFecha();
	}




	
	
	
}
