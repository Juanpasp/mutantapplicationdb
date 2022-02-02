package com.mutant.project.mutantapplicationdb.persistence.converters.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutant.project.mutantapplicationdb.persistence.converters.GenerateEntitieDna;
import com.mutant.project.mutantapplicationdb.persistence.entities.Dna;

@RunWith(SpringRunner.class)
public class GenerateEntitieDnaTest {

	private GenerateEntitieDna entitieDna = new GenerateEntitieDna();
	
	@Test
	void testSetEntitieDna() {
		List<String> listDna = new ArrayList<>();
		listDna.add("ATGCGA");
		listDna.add("CAGTGC");
		assertThat(entitieDna.setEntitieDna(listDna, true)).isInstanceOf(Dna.class);
	}
}
