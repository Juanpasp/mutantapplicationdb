package com.mutant.project.mutantapplicationdb.delivery.converters.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutant.project.mutantapplicationdb.delivery.converters.GenerateResponseStat;
import com.mutant.project.mutantapplicationdb.persistence.entities.Dna;

@RunWith(SpringRunner.class)
public class GenerateResponseStatTest {
	
	private GenerateResponseStat responseStat = new GenerateResponseStat();
	
	@Test
	void testSaveStatResponseWithListIsEmpty() {
		
		List<Dna> listDna = new ArrayList<>();
		Long result = (long) 0;
		assertThat(responseStat.saveStatResponse(listDna).getCountHumanDna()).isEqualTo(result);
		
	}
	
	@Test
	void testSaveStatResponseWithIsListNotEmpty() {
		Dna dnaRegister1 = new Dna();
		dnaRegister1.setId((long) 1);
		dnaRegister1.setIsMutant(true);
		dnaRegister1.setRequestDna("{ATGCGA CAGTGC TTATGT AGAAGG CCCCTA TCACTG}");
		
		Dna dnaRegister2 = new Dna();
		dnaRegister2.setId((long) 2);
		dnaRegister2.setIsMutant(true);
		dnaRegister2.setRequestDna("{ATGCGA CAGTGC TTATGT AGAAGG CCCCTA TCACTG}");
		
		Dna dnaRegister3 = new Dna();
		dnaRegister3.setId((long) 3);
		dnaRegister3.setIsMutant(false);
		dnaRegister3.setRequestDna("{TTGCGA CAGTGC TTATGT AGAAGG TCCCTA TCACTG}");
		
		List<Dna> listDna = new ArrayList<>();
		listDna.add(dnaRegister1);
		listDna.add(dnaRegister2);
		listDna.add(dnaRegister3);
		
		Long result = (long) 3;
		
		assertThat(responseStat.saveStatResponse(listDna).getCountHumanDna())
		.isEqualTo(result);
		
	}

}
