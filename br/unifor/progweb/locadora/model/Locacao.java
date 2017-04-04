package br.unifor.progweb.locadora.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the locacao database table.
 * 
 */
@Entity
@NamedQuery(name="Locacao.findAll", query="SELECT l FROM Locacao l")
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LocacaoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_devolucao")
	private Date dataDevolucao;

	@Temporal(TemporalType.DATE)
	@Column(name="data_emprestimo")
	private Date dataEmprestimo;

	@Column(name="hora_emprestimo")
	private Time horaEmprestimo;

	@Lob
	private String obs;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cod_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Midia
	@ManyToOne
	@JoinColumn(name="cod_midia")
	private Midia midia;

	public Locacao() {
	}

	public LocacaoPK getId() {
		return this.id;
	}

	public void setId(LocacaoPK id) {
		this.id = id;
	}

	public Date getDataDevolucao() {
		return this.dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Date getDataEmprestimo() {
		return this.dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Time getHoraEmprestimo() {
		return this.horaEmprestimo;
	}

	public void setHoraEmprestimo(Time horaEmprestimo) {
		this.horaEmprestimo = horaEmprestimo;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Midia getMidia() {
		return this.midia;
	}

	public void setMidia(Midia midia) {
		this.midia = midia;
	}

}