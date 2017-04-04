package br.unifor.progweb.locadora.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_categoria")
	private int codCategoria;

	private String descricao;

	//bi-directional many-to-one association to Filme
	@OneToMany(mappedBy="categoria")
	private List<Filme> filmes;

	public Categoria() {
	}

	public int getCodCategoria() {
		return this.codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Filme> getFilmes() {
		return this.filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public Filme addFilme(Filme filme) {
		getFilmes().add(filme);
		filme.setCategoria(this);

		return filme;
	}

	public Filme removeFilme(Filme filme) {
		getFilmes().remove(filme);
		filme.setCategoria(null);

		return filme;
	}

}