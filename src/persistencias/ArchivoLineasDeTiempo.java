package persistencias;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import lineasDeTiempo.LineaDeTiempo;

public class ArchivoLineasDeTiempo {

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
}
