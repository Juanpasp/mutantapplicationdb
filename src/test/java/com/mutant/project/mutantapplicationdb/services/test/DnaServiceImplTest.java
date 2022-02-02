package com.mutant.project.mutantapplicationdb.services.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutant.project.mutantapplicationdb.persistence.entities.Dna;
import com.mutant.project.mutantapplicationdb.persistence.repositories.DnaRepository;
import com.mutant.project.mutantapplicationdb.services.DnaServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class DnaServiceImplTest {

	@Mock
	private DnaRepository dnaRepository;
	@InjectMocks
	private DnaServiceImpl dnaService;
	
	@Test
	void testSaveDna() {
		Dna dna = new Dna();
		dna.setId((long) 123123123);
		dna.setIsMutant(true);
		dna.setRequestDna("{ATGCGA CAGTGC TTATGT AGAAGG CCCCTA TCACTG}");
		dnaService.saveDna(dna);
		verify(dnaRepository, times(1)).save(dna);
	}
	
	@Test
	void testGetAllDnas() {
		Dna dna = new Dna();
		dna.setId((long) 9999);
		dna.setIsMutant(true);
		dna.setRequestDna("{ATGCGA CAGTGC TTATGT AGAAGG CCCCTA TCACTG}");
		List<Dna> listDna = new ArrayList<>();
		listDna.add(dna);
		when(dnaRepository.findAll()).thenReturn(listDna);
		assertThat(dnaService.getAllDnas()).isEqualTo(listDna);
	}
}
