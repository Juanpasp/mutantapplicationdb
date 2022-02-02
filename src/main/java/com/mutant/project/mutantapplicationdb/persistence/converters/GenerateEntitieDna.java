package com.mutant.project.mutantapplicationdb.persistence.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mutant.project.mutantapplicationdb.persistence.entities.Dna;

@Component
public class GenerateEntitieDna {

	/***
	 * Recibe como parametros la lista de caracteres de Adn y el resultado del analisis,
	 * almacenandolo en la entidad Dna
	 * @param listAdn
	 * @param isMutant
	 * @return
	 */
	public Dna setEntitieDna(List<String> listAdn, Boolean isMutant) {
		String result = listAdn.stream()
			      .map(n -> String.valueOf(n))
			      .collect(Collectors.joining(" ", "{", "}"));
		Dna dna = new Dna();
		dna.setRequestDna(result);
		dna.setIsMutant(isMutant);
		return dna;
	}

}
