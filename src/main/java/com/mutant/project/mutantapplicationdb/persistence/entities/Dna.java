package com.mutant.project.mutantapplicationdb.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Dna {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private String requestDna;
	
	@Column
	private boolean isMutant;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestDna() {
		return requestDna;
	}

	public void setRequestDna(String requestDna) {
		this.requestDna = requestDna;
	}

	public boolean getIsMutant() {
		return isMutant;
	}

	public void setIsMutant(boolean isMutant2) {
		this.isMutant = isMutant2;
	}



}
