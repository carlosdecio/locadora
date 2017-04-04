package br.unifor.progweb.locadora.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the midia database table.
 * 
 */
@Entity
@NamedQuery(name="Midia.findAll", query="SELECT m FROM Midia m")
public class Midia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_midia")
	private int codMidia;

	private String inutilizada;

	//bi-directional many-to-one association to Locacao
	@OneToMany(mappedBy="midia")
	private List<Locacao> locacaos;

	//bi-directional many-to-one association to Filme
	@ManyToOne
	@JoinColumn(name="cod_filme")
	private Filme filme;

	public Midia() {
	}

	public int getCodMidia() {
		return this.codMidia;
	}

	public void setCodMidia(int codMidia) {
		this.codMidia = codMidia;
	}

	public String getInutilizada() {
		return this.inutilizada;
	}

	public void setInutilizada(String inutilizada) {
		this.inutilizada = inutilizada;
	}

	public List<Locacao> getLocacaos() {
		return this.locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}

	public Locacao addLocacao(Locacao locacao) {
		getLocacaos().add(locacao);
		locacao.setMidia(this);

		return locacao;
	}

	public Locacao removeLocacao(Locacao locacao) {
		getLocacaos().remove(locacao);
		locacao.setMidia(null);

		return locacao;
	}

	public Filme getFilme() {
		return this.filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}