package br.unifor.progweb.locadora.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the locacao database table.
 * 
 */
@Embeddable
public class LocacaoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_locacao")
	private int codLocacao;

	@Column(name="cod_cliente", insertable=false, updatable=false)
	private int codCliente;

	@Column(name="cod_midia", insertable=false, updatable=false)
	private int codMidia;

	public LocacaoPK() {
	}
	public int getCodLocacao() {
		return this.codLocacao;
	}
	public void setCodLocacao(int codLocacao) {
		this.codLocacao = codLocacao;
	}
	public int getCodCliente() {
		return this.codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public int getCodMidia() {
		return this.codMidia;
	}
	public void setCodMidia(int codMidia) {
		this.codMidia = codMidia;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LocacaoPK)) {
			return false;
		}
		LocacaoPK castOther = (LocacaoPK)other;
		return 
			(this.codLocacao == castOther.codLocacao)
			&& (this.codCliente == castOther.codCliente)
			&& (this.codMidia == castOther.codMidia);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codLocacao;
		hash = hash * prime + this.codCliente;
		hash = hash * prime + this.codMidia;
		
		return hash;
	}
}