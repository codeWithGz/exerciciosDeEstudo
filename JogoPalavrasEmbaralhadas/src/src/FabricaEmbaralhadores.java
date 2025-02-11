package src;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import embaralhadores.EmbaralhadorAleatorio;
import embaralhadores.EmbaralhadorInvertido;

public class FabricaEmbaralhadores{

	
	private static final List<Embaralhador> listaDeEmbaralhadores = Arrays.asList(
			new EmbaralhadorInvertido(),
			new EmbaralhadorAleatorio()
			);
	
	public static final Embaralhador getEmbaralhadorAleatorio() {
		return listaDeEmbaralhadores.get(new Random().nextInt(listaDeEmbaralhadores.size()));
	}
	
	

}
