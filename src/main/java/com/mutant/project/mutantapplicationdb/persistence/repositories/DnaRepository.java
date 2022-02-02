package com.mutant.project.mutantapplicationdb.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mutant.project.mutantapplicationdb.persistence.entities.Dna;

@Repository
public interface DnaRepository extends CrudRepository<Dna, Long> {

}
