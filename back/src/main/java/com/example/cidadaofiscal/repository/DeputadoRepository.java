package com.example.cidadaofiscal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.cidadaofiscal.beans.Deputado;


public interface DeputadoRepository extends JpaRepository<Deputado, Long> {

}
