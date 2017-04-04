package br.unifor.progweb.locadora.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_cliente")
	private int codCliente;

	private String bairro;

	private String cep;

	private String cidade;

	@Lob
	private String complemento;

	private String estado;

	private int numero;

	private String rua;

	//bi-directional one-to-one association to Cliente
	@OneToOne
	@JoinColumn(name="cod_cliente")
	private Cliente cliente;

	public Endereco() {
	}

	public int getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}