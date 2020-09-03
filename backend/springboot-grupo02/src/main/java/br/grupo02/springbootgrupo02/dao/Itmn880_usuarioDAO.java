package br.grupo02.springbootgrupo02.dao;

import org.springframework.data.repository.CrudRepository;

import br.grupo02.springbootgrupo02.model.Itmn880_usuario;

public interface Itmn880_usuarioDAO extends CrudRepository <Itmn880_usuario, Integer> {
    public Itmn880_usuario findByEmailAndSenha(String email, String senha);
    public Itmn880_usuario findByEmailOrRacf(String email, String racf);
    
}
