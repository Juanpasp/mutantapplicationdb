package com.mutant.project.mutantapplicationdb.delivery;

import org.springframework.http.ResponseEntity;

import com.mutant.project.mutantapplicationdb.delivery.request.DnaRest;
import com.mutant.project.mutantapplicationdb.exceptions.MutantException;

public interface IDnaController {
	
	<T> ResponseEntity<T> validateDna(DnaRest dnaRest) throws MutantException;
	<T> ResponseEntity<T> getStatsDna();

}
