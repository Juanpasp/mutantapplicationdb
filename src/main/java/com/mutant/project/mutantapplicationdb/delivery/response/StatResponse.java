package com.mutant.project.mutantapplicationdb.delivery.response;

import java.io.Serializable;

public class StatResponse implements Serializable {
	
	private static final long serialVersionUID = 7302319210373510173L;
	
	private Long countMutantDna;
	private Long countHumanDna;
	private double ratio;
	
	public StatResponse() {}
	
	public StatResponse(Long countMutantDna, Long countHumanDna, double ratio) {
		super();
		this.countMutantDna = countMutantDna;
		this.countHumanDna = countHumanDna;
		this.ratio = ratio;
	}
	
	public Long getCountMutantDna() {
		return countMutantDna;
	}

	public void setCountMutantDna(Long countMutantDna) {
		this.countMutantDna = countMutantDna;
	}

	public Long getCountHumanDna() {
		return countHumanDna;
	}

	public void setCountHumanDna(Long countHumanDna) {
		this.countHumanDna = countHumanDna;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}


	
	
	
	

}
