package br.grupo02.springbootgrupo02.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.grupo02.springbootgrupo02.model.Itmn880_solic;

public interface Itmn880_solicDAO extends CrudRepository <Itmn880_solic, Integer> {
    public List<Itmn880_solic> findByStatus(char status);
    
}
