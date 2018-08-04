package persistencias;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fechas.Fecha;
import lineasDeTiempo.LineaDeTiempo;


public class ArchivoLineasDeTiempo {

	//Clase Linea de tiempo
	public void guardar (LineaDeTiempo x , String archivoName) throws FileNotFoundException, IOException {
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivoName));
		salida.writeObject(x);
		salida.close();
		
	}
	
	public LineaDeTiempo recuperar(  String archivoName ) throws IOException, ClassNotFoundException {
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivoName));
		LineaDeTiempo linea  = (LineaDeTiempo) entrada.readObject();
		entrada.close();
		return linea;
	}
	
	//Para Array de String
	
	public void guardarArrayString (ArrayList<String>  x , String archivoName) throws FileNotFoundException, IOException {
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivoName) );
		salida.writeObject(x);
		salida.close();
	}
	public ArrayList<String> recuperar2(String archivoNombre) throws IOException, ClassNotFoundException{
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivoNombre));	
		ArrayList<String> lista =  ( ArrayList<String> ) entrada.readObject();
		entrada.close();
		return lista;
	}
	
	//Para Array de Fechas
	
	public void guardarFechas(ArrayList<Fecha>  x , String archivoName) throws FileNotFoundException, IOException {
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivoName) );
		salida.writeObject(x);
		salida.close();
	}
	public ArrayList<Fecha> recuperar3(String archivoNombre) throws IOException, ClassNotFoundException{
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivoNombre));	
		ArrayList<Fecha> lista =  ( ArrayList<Fecha> ) entrada.readObject();
		entrada.close();
		return lista;
	}
	

}
