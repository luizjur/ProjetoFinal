
package br.grupo02.springbootgrupo02.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itmn880_usuario")
public class Itmn880_usuario {

    @Id //chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-numeração
    @Column(name="id")
    private int id;

    @Column(name="racf", length = 8, nullable = false)
    private String racf;

    @Column(name="email", length = 50, nullable = false)
    private String email;

    @Column(name="senha", length = 20, nullable = false)
    private String senha;

    @Column(name="nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name="linkFoto", length = 200, nullable = false)
    private String linkFoto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}


}
