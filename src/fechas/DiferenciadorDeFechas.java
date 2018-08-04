package fechas;

public class DiferenciadorDeFechas {

	public String mostrarDiferencia(Fecha fecha1 , Fecha fecha2 ) {
		
		int anio2 = fecha2.getAnio();
		int anio1 = fecha1.getAnio();		
		int mes2 = fecha2.getMes();
		int mes1 =fecha1 .getMes();	
		int dia2 = fecha2.getDia();
		int dia1 = fecha1.getDia();
		
		 int aniosTotales=0,mesesTotales=0;
		 int cantidadDiasDiferencia;
		 int cantidadDias1=0 ,cantidadDias2=0;
		 
		 for(int i =0 ; i < mes1 -1 ; i++) 	 cantidadDias1 = cantidadDias1 + 30 ;
		 cantidadDias1 = cantidadDias1 + dia1 ;
		 
		 for(int i =0 ; i < mes2 -1 ; i++) 	 cantidadDias2 = cantidadDias2 + 30 ;
		 cantidadDias2 = cantidadDias2 + dia2;
		 
		 if(  anio2 > anio1 )	 cantidadDiasDiferencia = ( 365* (anio2 -anio1) ) + ( cantidadDias2-cantidadDias1 );	 
		 else 	 cantidadDiasDiferencia = ( 365*( anio1 -anio2  ) ) + ( cantidadDias1-cantidadDias2 );
		 		
		 cantidadDiasDiferencia = Math.abs(cantidadDiasDiferencia);
		 
		 boolean condicion = true;
		 
		 while(condicion) {
			 cantidadDiasDiferencia = cantidadDiasDiferencia - 365 ;
			 if (cantidadDiasDiferencia > 0) aniosTotales =aniosTotales+1;
			 else {
				 cantidadDiasDiferencia=cantidadDiasDiferencia+365;
				 condicion = false;
			 }
		 }
		 
		 condicion = true;
		 
		 while(condicion) {
			 cantidadDiasDiferencia = cantidadDiasDiferencia - 30 ;
			 if (cantidadDiasDiferencia > 0) mesesTotales =mesesTotales+1;
			 else {
				 if(mesesTotales > 11) {
					 aniosTotales = aniosTotales +1 ;
					 mesesTotales = mesesTotales - 12 ;
				 }
				 cantidadDiasDiferencia=cantidadDiasDiferencia+30;
				 condicion = false;
			 }
		 }
		 	
		return ("Diferencia Aproximada : "+aniosTotales+" años "+mesesTotales+" meses "+cantidadDiasDiferencia+ " dias");
	
	}
	
}
