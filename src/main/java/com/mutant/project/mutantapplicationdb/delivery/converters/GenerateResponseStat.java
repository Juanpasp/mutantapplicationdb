package com.mutant.project.mutantapplicationdb.delivery.converters;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mutant.project.mutantapplicationdb.delivery.response.StatResponse;
import com.mutant.project.mutantapplicationdb.persistence.entities.Dna;

@Component
public class GenerateResponseStat {
	
	/***
	 * Recibe como parametro un ArrayList y almacena el objeto StatResponse
	 * que contiene las estadisticas de los adn analizados
	 * @param listDna
	 * @return
	 */
	public StatResponse saveStatResponse(List<Dna> listDna) {
		Long countMutant = listDna.stream().filter(itemToEvaluate -> 
		itemToEvaluate.getIsMutant()).count();
		Long countHuman = listDna.stream().count();
		double ratio = (double)((double)countMutant/(double)countHuman);
		return new StatResponse(countMutant, countHuman, ratio);
	}
	
	

}
