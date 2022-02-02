package com.mutant.project.mutantapplicationdb.delivery.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutant.project.mutantapplicationdb.delivery.DnaControllerImpl;
import com.mutant.project.mutantapplicationdb.delivery.converters.GenerateResponseStat;
import com.mutant.project.mutantapplicationdb.delivery.request.DnaRest;
import com.mutant.project.mutantapplicationdb.exceptions.MutantException;
import com.mutant.project.mutantapplicationdb.persistence.converters.GenerateEntitieDna;
import com.mutant.project.mutantapplicationdb.persistence.entities.Dna;
import com.mutant.project.mutantapplicationdb.services.DnaService;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class DnaControllerImplTest {
	
	@Mock
	private DnaService dnaService;
	@Mock
	private GenerateResponseStat generateResponse;
	@Mock
	private GenerateEntitieDna generateEntitie;
	@InjectMocks
	private DnaControllerImpl dnaController;
	
	private DnaRest restSuccess = new DnaRest();
	private DnaRest restError = new DnaRest();
	private DnaRest restErrorCharacters = new DnaRest();
	private DnaRest restErrorListEmpty = new DnaRest();
	
		
	@BeforeEach
	void initParameters() {
		String[] dnaErrorCharacters = {"XTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
		String[] dnaError = {"TTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "TCCCTA", "TCACTG"};
		String[] dnaSuccess = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
		String[] dnaErrorEmpty = {};
		restErrorCharacters.setDna(dnaErrorCharacters);
		restError.setDna(dnaError);
		restSuccess.setDna(dnaSuccess);
		restErrorListEmpty.setDna(dnaErrorEmpty);
		
	}
	
	@Test
	void testValidateDnaWithErrorCharactersInTheArray() throws MutantException {
		
		assertThat(dnaController.validateDna(restErrorCharacters)).isInstanceOf(ResponseEntity.class);
		
	}
	
	@Test
	void testValidateDnaWithListCaracthersIsEmpty() throws MutantException {
		assertThat(dnaController.validateDna(restErrorListEmpty)).isInstanceOf(ResponseEntity.class);
	}
	
	@Test
	void testValidateDnaWhenResultIsHuman() throws MutantException {
		List<String> listAdn = Arrays.asList(restError.getDna());
		Dna dna = new Dna();
		dna.setId((long) 9999);
		dna.setIsMutant(false);
		dna.setRequestDna("{TTGCGA CAGTGC TTATGT AGAAGG TCCCTA TCACTG}");
		when(generateEntitie.setEntitieDna(listAdn, false)).thenReturn(dna);
		assertThat(dnaController.validateDna(restError)).isInstanceOf(ResponseEntity.class);
	}
	
	@Test
	void testValidateDnaWhenResultIsMutant() throws MutantException {
		List<String> listAdn = Arrays.asList(restSuccess.getDna());
		Dna dna = new Dna();
		dna.setId((long) 9999);
		dna.setIsMutant(true);
		dna.setRequestDna("{ATGCGA CAGTGC TTATGT AGAAGG CCCCTA TCACTG}");
		when(generateEntitie.setEntitieDna(listAdn, true)).thenReturn(dna);
		assertThat(dnaController.validateDna(restSuccess)).isInstanceOf(ResponseEntity.class);
	}
	
	@Test
	void testGetStatsDna() {
		Dna dna = new Dna();
		dna.setId((long) 9999);
		dna.setIsMutant(true);
		dna.setRequestDna("{ATGCGA CAGTGC TTATGT AGAAGG CCCCTA TCACTG}");
		List<Dna> listAdn = new ArrayList<>();
		listAdn.add(dna);
		when(dnaService.getAllDnas()).thenReturn(listAdn);
		assertThat(dnaController.getStatsDna()).isInstanceOf(ResponseEntity.class);
	}

}
