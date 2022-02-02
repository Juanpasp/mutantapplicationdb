package com.mutant.project.mutantapplicationdb.usescases.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutant.project.mutantapplicationdb.usescases.DetailMutantBusinessImpl;
import com.mutant.project.mutantapplicationdb.utils.Constants;

@RunWith(SpringRunner.class)
public class DetailMutantBusinessImplTest {
	
	private DetailMutantBusinessImpl detailMutantBusinessImpl = new DetailMutantBusinessImpl();
	
	private Map<Integer, Integer> mapCharactersAdn = new HashMap<>();
	
	static final String EMPTY_CONSTANT = "";
	
	static final String VALUE_CONSTANT_PREVIOUS_VALUE_LEFTOBLIQUE_1 = "ATGCGA";
	static final String VALUE_CONSTANT_PREVIOUS_VALUE_LEFTOBLIQUE_2 = "ATACGA";
	static final String VALUE_CONSTANT_PREVIOUS_VALUE_LEFTOBLIQUE_3 = "ATGCTA";
	static final String VALUE_CONSTANT_CURRENT_VALUE_LEFTOBLIQUE_1 = "CAGTGC";
	
	static final String VALUE_CONSTANT_PREVIOUS_VALUE_RIGHTOBLIQUE_1 = "ATGCGA";
	static final String VALUE_CONSTANT_PREVIOUS_VALUE_RIGHTOBLIQUE_2 = "ATACGA";
	static final String VALUE_CONSTANT_PREVIOUS_VALUE_RIGHTOBLIQUE_3 = "ATGCTA";
	static final String VALUE_CONSTANT_PREVIOUS_VALUE_RIGHTOBLIQUE_4 = "AGGCTA";
	static final String VALUE_CONSTANT_CURRENT_VALUE_RIGHTOBLIQUE_1 = "CCGTGC";
	static final String VALUE_CONSTANT_CURRENT_VALUE_RIGHTOBLIQUE_2 = "CAGTGC";
	static final String VALUE_CONSTANT_CURRENT_VALUE_RIGHTOBLIQUE_3 = "CCGTGC";
	
	static final String VALUE_CONSTANT_CURRENT_VALUE_HORIZONTAL_1 = "CCCCTA";
	static final String VALUE_CONSTANT_CURRENT_VALUE_HORIZONTAL_2 = "TCACTG";
	static final String VALUE_CONSTANT_CURRENT_VALUE_HORIZONTAL_3 = "AAAATA";
	static final String VALUE_CONSTANT_CURRENT_VALUE_HORIZONTAL_4 = "CTTTTA";
	static final String VALUE_CONSTANT_CURRENT_VALUE_HORIZONTAL_5 = "GGGGTA";

	static final String VALUE_CONSTANT_PREVIOUS_VALUE_VERTICAL_1 = "ATGCGA";
	static final String VALUE_CONSTANT_PREVIOUS_VALUE_VERTICAL_2 = "ATACCA";
	static final String VALUE_CONSTANT_CURRENT_VALUE_VERTICAL_1 = "CATTGC";
	static final String VALUE_CONSTANT_CURRENT_VALUE_VERTICAL_2 = "CAGTCC";
	
	
	@BeforeEach
	void init() {
		
		mapCharactersAdn.put(3, 2);
		mapCharactersAdn.put(4, 1);
		mapCharactersAdn.put(1,3);
	}
	
	
	@Test
	void testMethodValidateRegisterCoincidentOfLeftObliqueWhenPreviousValueIsEmpty() {
		
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfLeftOblique(EMPTY_CONSTANT, VALUE_CONSTANT_CURRENT_VALUE_LEFTOBLIQUE_1, mapCharactersAdn))
			.isEqualTo(mapCharactersAdn);
		
	}
	
	@Test
	void testMethodValidateRegisterCoincidentOfLeftObliqueWhenPreviousValueIsNotEqualToCurrentValue() {
		
		Map<Integer, Integer> valueAdn = new HashMap<>();
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfLeftOblique(VALUE_CONSTANT_PREVIOUS_VALUE_LEFTOBLIQUE_1, VALUE_CONSTANT_CURRENT_VALUE_LEFTOBLIQUE_1, mapCharactersAdn))
			.isEqualTo(valueAdn);
		
	}
	
	@Test
	void testMethodValidateRegisterCoincidentOfLeftObliqueWhenPreviousValueIsEqualToCurrentValueAndFistRegisterFind() {
		
		Map<Integer, Integer> valueAdn = new HashMap<>();
		valueAdn.put(1, Constants.VALUE_INITIAL_COINCIDENT);
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfLeftOblique(VALUE_CONSTANT_PREVIOUS_VALUE_LEFTOBLIQUE_2, VALUE_CONSTANT_CURRENT_VALUE_LEFTOBLIQUE_1, mapCharactersAdn))
			.isEqualTo(valueAdn);
		
	}
	
	@Test
	void testMethodValidateRegisterCoincidentOfLeftObliqueWhenPreviousValueIsEqualToCurrentValueAndMoreOneRegistercoincident() {
		
		Map<Integer, Integer> valueAdn = new HashMap<>();
		valueAdn.put(3, 2);
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfLeftOblique(VALUE_CONSTANT_PREVIOUS_VALUE_LEFTOBLIQUE_3, VALUE_CONSTANT_CURRENT_VALUE_LEFTOBLIQUE_1, mapCharactersAdn))
			.isEqualTo(valueAdn);
		
	}
		
	@Test
	void testMethodValidateRegisterCoincidentOfRightObliqueWhenPreviousValueIsEmpty() {
		
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfRightOblique(EMPTY_CONSTANT, VALUE_CONSTANT_CURRENT_VALUE_RIGHTOBLIQUE_1, mapCharactersAdn))
			.isEqualTo(mapCharactersAdn);
		
	}
	
	@Test
	void testMethodValidateRegisterCoincidentOfRightObliqueWhenPreviousValueIsNotEqualToCurrentValue() {
		
		Map<Integer, Integer> valueAdn = new HashMap<>();
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfRightOblique(VALUE_CONSTANT_PREVIOUS_VALUE_RIGHTOBLIQUE_1, VALUE_CONSTANT_CURRENT_VALUE_RIGHTOBLIQUE_1, mapCharactersAdn))
			.isEqualTo(valueAdn);
		
	}
	
	@Test
	void testMethodValidateRegisterCoincidentOfRightObliqueWhenPreviousValueIsEqualToCurrentValueAndFistRegisterFind() {
		
		Map<Integer, Integer> valueAdn = new HashMap<>();
		valueAdn.put(1, Constants.VALUE_INITIAL_COINCIDENT);
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfRightOblique(VALUE_CONSTANT_PREVIOUS_VALUE_RIGHTOBLIQUE_2, VALUE_CONSTANT_CURRENT_VALUE_RIGHTOBLIQUE_2, mapCharactersAdn))
			.isEqualTo(valueAdn);
		
	}
	
	@Test
	void testMethodValidateRegisterCoincidentOfRightObliqueWhenPreviousValueIsEqualToCurrentValueAndMoreOneRegistercoincident() {
		
		Map<Integer, Integer> valueAdn = new HashMap<>();
		valueAdn.put(2, 4);
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfRightOblique(VALUE_CONSTANT_PREVIOUS_VALUE_RIGHTOBLIQUE_4, VALUE_CONSTANT_CURRENT_VALUE_RIGHTOBLIQUE_3, mapCharactersAdn))
			.isEqualTo(valueAdn);
		
	}

	@Test
	void testMethodValidateRegisterCoincidentOfHorizontalWhenReturnFalse() {
		
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfHorizontal(VALUE_CONSTANT_CURRENT_VALUE_HORIZONTAL_2))
		.isFalse();
		
	}
	
	@Test
	void testMethodValidateRegisterCoincidentOfHorizontalWhenReturnTrueWithC() {
		
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfHorizontal(VALUE_CONSTANT_CURRENT_VALUE_HORIZONTAL_1))
		.isTrue();
		
	}
	
	@Test
	void testMethodValidateRegisterCoincidentOfHorizontalWhenReturnTrueWithA() {
		
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfHorizontal(VALUE_CONSTANT_CURRENT_VALUE_HORIZONTAL_3))
		.isTrue();
		
	}
	
	@Test
	void testMethodValidateRegisterCoincidentOfHorizontalWhenReturnTrueWithT() {
		
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfHorizontal(VALUE_CONSTANT_CURRENT_VALUE_HORIZONTAL_4))
		.isTrue();
		
	}
	
	@Test
	void testMethodValidateRegisterCoincidentOfHorizontalWhenReturnTrueWithG() {
		
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfHorizontal(VALUE_CONSTANT_CURRENT_VALUE_HORIZONTAL_5))
		.isTrue();
		
	}
	
	
	@Test
	void testMethodValidateRegisterCoincidentOfVerticalWhenPreviousValueIsEmpty() {
		
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfVertical(EMPTY_CONSTANT, VALUE_CONSTANT_CURRENT_VALUE_RIGHTOBLIQUE_1, mapCharactersAdn))
			.isEqualTo(mapCharactersAdn);
		
	}
	
	@Test
	void testMethodValidateRegisterCoincidentOfVerticalWhenPreviousValueIsNotEqualToCurrentValue() {
		
		Map<Integer, Integer> valueAdn = new HashMap<>();
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfVertical(VALUE_CONSTANT_PREVIOUS_VALUE_VERTICAL_2, VALUE_CONSTANT_CURRENT_VALUE_VERTICAL_1, mapCharactersAdn))
			.isEqualTo(valueAdn);
		
	}
	
	@Test
	void testMethodValidateRegisterCoincidentOfVerticalWhenPreviousValueIsEqualToCurrentValueAndFistRegisterFind() {
		
		Map<Integer, Integer> valueAdn = new HashMap<>();
		valueAdn.put(2, Constants.VALUE_INITIAL_COINCIDENT);
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfVertical(VALUE_CONSTANT_PREVIOUS_VALUE_VERTICAL_1, VALUE_CONSTANT_CURRENT_VALUE_VERTICAL_2, mapCharactersAdn))
			.isEqualTo(valueAdn);
		
	}
	
	@Test
	void testMethodValidateRegisterCoincidentOfVerticalWhenPreviousValueIsEqualToCurrentValueAndMoreOneRegistercoincident() {
		
		Map<Integer, Integer> valueAdn = new HashMap<>();
		valueAdn.put(4, 2);
		assertThat(detailMutantBusinessImpl
				.validateRegisterCoincidentOfVertical(VALUE_CONSTANT_PREVIOUS_VALUE_VERTICAL_1, VALUE_CONSTANT_CURRENT_VALUE_VERTICAL_1, mapCharactersAdn))
			.isEqualTo(valueAdn);
		
	}

}
