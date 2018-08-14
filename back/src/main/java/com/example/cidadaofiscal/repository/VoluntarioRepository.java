package com.example.cidadaofiscal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cidadaofiscal.beans.Voluntario;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Long>{
	@Query(
	value = "Select count(*) from voluntario", nativeQuery = true)
	Integer getAllVolunters();
}
