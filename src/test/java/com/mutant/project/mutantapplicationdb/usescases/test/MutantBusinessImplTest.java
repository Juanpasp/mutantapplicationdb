package com.mutant.project.mutantapplicationdb.usescases.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutant.project.mutantapplicationdb.exceptions.MutantException;
import com.mutant.project.mutantapplicationdb.usescases.DetailMutantBusinessImpl;
import com.mutant.project.mutantapplicationdb.usescases.MutantBusinessImpl;

@RunWith(SpringRunner.class)
public class MutantBusinessImplTest {
	
	private DetailMutantBusinessImpl detailMutantBusinessImpl = new DetailMutantBusinessImpl();
	private MutantBusinessImpl mutantBusinessImpl= new MutantBusinessImpl(detailMutantBusinessImpl);
	
	@Test()
	void testIsMutantException() throws MutantException {
		
		List<String> adnList = new ArrayList<>();
					
		assertThrows(MutantException.class, () -> {
			mutantBusinessImpl.isMutant(adnList);
		});
		
		
	}
	
	@Test
	void testStructureHorizontalIsTrue() throws MutantException {
		
		List<String> adnList = new ArrayList<>();
		adnList.add("GGGGTA");
		adnList.add("CAGTGC");
		adnList.add("TTATGT");
		adnList.add("AGAAGG");
		adnList.add("CCCCTA");
		adnList.add("TCACTG");
		
		assertThat(mutantBusinessImpl.isMutant(adnList)).isTrue();
		
	}
	
	
	@Test
	void testIsMutantWhenReturnIsTrue() throws MutantException {
		
		List<String> adnList = new ArrayList<>();
		adnList.add("ATGCGA");
		adnList.add("CAGTGC");
		adnList.add("TTATGT");
		adnList.add("AGAAGG");
		adnList.add("CCCCTA");
		adnList.add("TCACTG");
		
		assertThat(mutantBusinessImpl.isMutant(adnList)).isTrue();
		
	}
	
	@Test
	void testIsMutantWhenReturnIsTrueWhenLefObliqueCoincident() throws MutantException {
		
		List<String> adnList = new ArrayList<>();
		adnList.add("ATGCGA");
		adnList.add("CAGGGC");
		adnList.add("TTGTGT");
		adnList.add("AGAAGG");
		adnList.add("CCCCTA");
		adnList.add("TCACTG");
		
		assertThat(mutantBusinessImpl.isMutant(adnList)).isTrue();
		
	}
	
	@Test
	void testIsMutantWhenReturnIsFalse() throws MutantException {
		
		List<String> adnList = new ArrayList<>();
		adnList.add("TTGCGA");
		adnList.add("CAGTGC");
		adnList.add("TTATGT");
		adnList.add("AGAAGG");
		adnList.add("GCCCTA");
		adnList.add("TCACTG");
		
		assertThat(mutantBusinessImpl.isMutant(adnList)).isFalse();
		
	}

}
