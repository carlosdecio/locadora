package br.unifor.progweb.locadora.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the filme database table.
 * 
 */
@Entity
@NamedQuery(name="Filme.findAll", query="SELECT f FROM Filme f")
public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_filme")
	private int codFilme;

	@Temporal(TemporalType.DATE)
	private Date ano;

	private String descricao;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="cod_categoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Midia
	@OneToMany(mappedBy="filme")
	private List<Midia> midias;

	public Filme() {
	}

	public int getCodFilme() {
		return this.codFilme;
	}

	public void setCodFilme(int codFilme) {
		this.codFilme = codFilme;
	}

	public Date getAno() {
		return this.ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Midia> getMidias() {
		return this.midias;
	}

	public void setMidias(List<Midia> midias) {
		this.midias = midias;
	}

	public Midia addMidia(Midia midia) {
		getMidias().add(midia);
		midia.setFilme(this);

		return midia;
	}

	public Midia removeMidia(Midia midia) {
		getMidias().remove(midia);
		midia.setFilme(null);

		return midia;
	}

}