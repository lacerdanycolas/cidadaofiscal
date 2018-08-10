package com.example.cidadaofiscal.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cidadaofiscal.beans.CfAlepe;
import com.example.cidadaofiscal.beans.DeputadoDTO;
import com.example.cidadaofiscal.beans.DespesaDTO;
import com.example.cidadaofiscal.beans.FornecedorDTO;
import com.example.cidadaofiscal.beans.PesquisaDTO;
import com.example.cidadaofiscal.repository.CfAlepeRepository;

@Service
public class CfAlepeService {

    @Autowired
    private CfAlepeRepository cfAlepeRepository;



    public List<CfAlepe> findAll(){
        return cfAlepeRepository.findAll();
    }

    public CfAlepe findOne(Long id) {
        return cfAlepeRepository.findById(id).get();
    }

    public List<DeputadoDTO> getDeputadosView(){
        List<DeputadoDTO> deputados = new ArrayList<DeputadoDTO>();
        List<Object[]> result = cfAlepeRepository.getDeputadosView();
        result.forEach(r -> deputados.add(new DeputadoDTO(r[0].toString(), r[1].toString(), r[2].toString())));
        return deputados;
    }

    public List<DespesaDTO> getDespesasView(){
        List<DespesaDTO> despesas = new ArrayList<DespesaDTO>();
        List<Object[]> result = cfAlepeRepository.getDespesasView();
        result.forEach(r -> despesas.add(new DespesaDTO(r[0].toString(), r[1].toString(), r[2].toString(), r[3].toString(), r[4].toString())));
        return despesas;
    }

    public List<FornecedorDTO> getFornecedoresView(){
        List<FornecedorDTO> fornecedores = new ArrayList<FornecedorDTO>();
        List<Object[]> result = cfAlepeRepository.getFornecedoresView();
        result.forEach(r -> fornecedores.add(new FornecedorDTO(r[0].toString(), r[1].toString(), r[2].toString())));
        return fornecedores;
    }

    public List<PesquisaDTO> getPesquisaResult(){
        List<PesquisaDTO> pesquisa = new ArrayList<PesquisaDTO>();
        List<Object[]> result = cfAlepeRepository.getPesquisaResults();
        result.forEach(r -> pesquisa.add(new PesquisaDTO(r[0].toString(), r[1].toString(), r[2].toString(), r[3].toString(), r[4].toString(), r[5].toString(), r[6].toString(), r[7].toString(), r[8].toString(), r[9].toString(), r[10].toString() )));
        return pesquisa;
    }

    public List<PesquisaDTO> getDeputadosFiltro(String name, String partido, String fornecedor, String valorMin, String valorMax, String dataMin, String dataMax) {
        List<PesquisaDTO> pesquisa = new ArrayList<PesquisaDTO>();
        List<Object[]> result = cfAlepeRepository.getDeputadosFiltro(name, partido, fornecedor, valorMin, valorMax, dataMin, dataMax);
        result.forEach(r -> pesquisa.add(new PesquisaDTO(r[0].toString(), r[1].toString(), r[2].toString(), r[3].toString(), r[4].toString(), r[5].toString(), r[6].toString(), r[7].toString(), r[8].toString(), r[9].toString(), r[10].toString() )));
        return pesquisa;
    }
}
