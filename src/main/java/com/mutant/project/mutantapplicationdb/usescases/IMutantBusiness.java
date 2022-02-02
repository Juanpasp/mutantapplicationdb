package com.mutant.project.mutantapplicationdb.usescases;

import java.util.List;

import com.mutant.project.mutantapplicationdb.exceptions.MutantException;

public interface IMutantBusiness {
	
	boolean isMutant(List<String> adnList) throws MutantException;

}
