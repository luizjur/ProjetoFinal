package br.grupo02.springbootgrupo02.model;


import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "itmn880_solic")

public class Itmn880_solic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="num_seq")
    private int numSeq;

    @Column(name="nome_tecnico" , length = 100, nullable = false)
    private String nomeTecnico;

    @Column(name="operadora" ,length = 50, nullable = false)
    private String operadora;

    @Column(name="telefone" ,length = 20, nullable = false)
    private String telefone;

    @Column(name="doc" , length = 20, nullable = false)
    private String doc;

    @Column(name="data")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data;

    @Column(name= "hora")
    private Time hora;

	@Column(name= "status")
    private char status;


    //@Column(name="pdv_id" , nullable = false)
    //private int pdvId;

    @ManyToOne
    @JsonIgnoreProperties("solicitacoes") 
    private Itmn880_pdv pdv;

	public int getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}
/*
	public int getPdvId() {
		return pdvId;
	}

	public void setPdvId(int pdvId) {
		this.pdvId = pdvId;
	}
*/

	public Itmn880_pdv getPdv() {
		return pdv;
	}

	public void setPdv(Itmn880_pdv pdv) {
		this.pdv = pdv;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	
    

}
