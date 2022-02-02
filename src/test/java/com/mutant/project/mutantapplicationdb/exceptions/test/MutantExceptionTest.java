package com.mutant.project.mutantapplicationdb.exceptions.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutant.project.mutantapplicationdb.exceptions.MutantException;

@RunWith(SpringRunner.class)
public class MutantExceptionTest {

	private MutantException exception = new MutantException("CODE_ERROR", "MESSAGE_ERROR") {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	};
	
	@Test
	void testGetCode() {
		assertThat(exception.getCode()).isNotEmpty();
	}
}
