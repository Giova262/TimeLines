package persistencias;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import lineasDeTiempo.LineaDeTiempo;

public class ArchivoLineasDeTiempo {

	public void guardar (LineaDeTiempo x) throws FileNotFoundException, IOException {
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("LineaDeTiempoDatos.obj"));
		salida.writeObject(x);
		salida.close();
		
	}
	
	public LineaDeTiempo recuperar() throws IOException, ClassNotFoundException {
		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("LineaDeTiempoDatos.obj"));
		LineaDeTiempo linea  = (LineaDeTiempo) entrada.readObject();
		entrada.close();
		return linea;
	}
}
