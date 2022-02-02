package com.mutant.project.mutantapplicationdb.delivery;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutant.project.mutantapplicationdb.delivery.converters.GenerateResponseStat;
import com.mutant.project.mutantapplicationdb.delivery.request.DnaRest;
import com.mutant.project.mutantapplicationdb.delivery.response.DnaResponseError;
import com.mutant.project.mutantapplicationdb.delivery.response.DnaResponseSuccess;
import com.mutant.project.mutantapplicationdb.exceptions.MutantException;
import com.mutant.project.mutantapplicationdb.persistence.converters.GenerateEntitieDna;
import com.mutant.project.mutantapplicationdb.persistence.entities.Dna;
import com.mutant.project.mutantapplicationdb.services.DnaService;
import com.mutant.project.mutantapplicationdb.usescases.DetailMutantBusinessImpl;
import com.mutant.project.mutantapplicationdb.usescases.MutantBusinessImpl;
import com.mutant.project.mutantapplicationdb.utils.Constants;
import com.mutant.project.mutantapplicationdb.utils.UtilsString;

@RestController
@RequestMapping("/api-analyze-mutant")
public class DnaControllerImpl implements IDnaController {
	
	@Autowired
	private DnaService dnaService;
	
	@Autowired
	private GenerateResponseStat generateResponse;
	
	@Autowired
	private GenerateEntitieDna generateEntitie;
	
	Logger logger = Logger.getLogger(DnaControllerImpl.class.getName());
	
	
	/***
	 * Metodo Post de path /mutant que recibe la solicitud del DNA e invoca el modulo de negocio
	 * para su analisis y procesamiento, si el resultado es mutante devuelve HTTP Status 200, de lo
	 * contrario retorna HTTP Status 403
	 */
	@SuppressWarnings("unchecked")
	@Override
	@PostMapping(path = "mutant",
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public <T> ResponseEntity<T> validateDna(@Valid @RequestBody DnaRest dnaRest) throws MutantException {
		
		try {
			List<String> listAdn = Arrays.asList(dnaRest.getDna());
			if (!listAdn.stream().allMatch(itemToEvaluate -> UtilsString.containsCharactersValids(itemToEvaluate))
					|| listAdn.isEmpty()) {
				logger.log(Level.WARNING, Constants.MESSAGE_VALIDATION_CHARACTERS);
				return new ResponseEntity<T>((T) new DnaResponseError(
						Constants.MESSAGE_RESPONSE_FORBIDDEN, Constants.CODE_ERROR_CHARACTERS_INVALID, 
						Constants.MESSAGE_ERROR_CHARACTERS_INVALID), HttpStatus.FORBIDDEN);
				
			} else {
				MutantBusinessImpl mutantBusiness = new MutantBusinessImpl(new DetailMutantBusinessImpl());
				Boolean isMutant = mutantBusiness.isMutant(listAdn);
				dnaService.saveDna(generateEntitie.setEntitieDna(listAdn, isMutant));
				if (isMutant) {
					logger.log(Level.INFO, Constants.MESSAGE_RESULT_MUTANT );
					return new ResponseEntity<T>((T) new DnaResponseSuccess(
							Constants.MESSAGE_RESPONSE_OK, true), HttpStatus.OK);
				} else {
					logger.log(Level.WARNING, Constants.MESSAGE_RESULT_HUMAN);
					return new ResponseEntity<T>((T) new DnaResponseError(
							Constants.MESSAGE_RESPONSE_FORBIDDEN, Constants.CODE_ERROR_HUMAN, 
							Constants.MESSAGE_ERROR_HUMAN), HttpStatus.FORBIDDEN);
				}
				
			}
			
		} catch (RuntimeException e) {
			logger.warning(Constants.MESSAGE_ERROR_EXECUTION);
			return new ResponseEntity<T>((T) new DnaResponseError(
					Constants.MESSAGE_RESPONSE_FORBIDDEN, Constants.CODE_ERROR_RUNTIME, 
					Constants.MESSAGE_ERROR_RUNTIME), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}


	@SuppressWarnings("unchecked")
	@Override
	@GetMapping("/stats")
	public <T> ResponseEntity<T> getStatsDna() {
		try {
			List<Dna> listDna = dnaService.getAllDnas();
			return new ResponseEntity<T>((T) generateResponse.saveStatResponse(listDna), HttpStatus.OK);
		} catch (RuntimeException e) {
			logger.warning(Constants.MESSAGE_ERROR_EXECUTION);
			return new ResponseEntity<T>((T) new DnaResponseError(
					Constants.MESSAGE_RESPONSE_FORBIDDEN, Constants.CODE_ERROR_RUNTIME, 
					Constants.MESSAGE_ERROR_RUNTIME), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
