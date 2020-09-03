package br.grupo02.springbootgrupo02.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "itmn880_pdv")

public class Itmn880_pdv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="numero_ponto" , nullable = false)
    private int numeroPonto;

    @Column(name="nome", length = 100, nullable = false)
    private String nome;

    @Column(name="endereco", length = 100, nullable = false)
    private String endereco;

    
    @Column(name="telefone", length = 20, nullable = false)
    private String telefone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pdv")
    @JsonIgnoreProperties("pdv")
    private List<Itmn880_solic> solicitacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroPonto() {
        return numeroPonto;
    }

    public void setNumeroPonto(int numeroPonto) {
        this.numeroPonto = numeroPonto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
