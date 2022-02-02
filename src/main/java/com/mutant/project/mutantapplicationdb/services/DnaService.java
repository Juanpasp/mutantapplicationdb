package com.mutant.project.mutantapplicationdb.services;

import java.util.List;

import com.mutant.project.mutantapplicationdb.persistence.entities.Dna;

public interface DnaService {
	
	void saveDna(Dna dna);
	List<Dna> getAllDnas();

}
