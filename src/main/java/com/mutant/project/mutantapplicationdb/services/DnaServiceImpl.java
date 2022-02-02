package com.mutant.project.mutantapplicationdb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutant.project.mutantapplicationdb.persistence.entities.Dna;
import com.mutant.project.mutantapplicationdb.persistence.repositories.DnaRepository;

@Service
public class DnaServiceImpl implements DnaService {
	
	@Autowired
	private DnaRepository dnaRepository;
	
	/***
	 * Almacena la informaci�n en la base de datos
	 */
	@Override
	public void saveDna(Dna dna) {
		dnaRepository.save(dna);
	}

	/***
	 * Recupera la informaci�n de la base de datos y devuelve una lista con la informaci�n
	 */
	@Override
	public List<Dna> getAllDnas() {
		List<Dna> listDna = new ArrayList<>();
		dnaRepository.findAll().forEach(itemDna -> listDna.add(itemDna));
		return listDna;
		
	}
	

}
