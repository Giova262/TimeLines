package fechas;

import java.util.Comparator;

import eventos.Evento;

public class SortFecha implements Comparator<Evento> {

	@Override
	public int compare(Evento o1, Evento o2) {
		return o1.compararloCon(o2);
	}


}
