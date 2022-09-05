package br.com.fiap.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_bigstar_comando")
@SequenceGenerator(name = "comando", sequenceName = "sq_t_bigstar_comando", allocationSize = 1)
public class Comando implements Serializable {
	
	private static final long serialVersionUID = -4156730017576618081L;
	
	public Comando() {
		
	}
	
	public Comando(int numero, String nome, String descricao, Usuario usuario) {
		this.numero = numero;
		this.nome = nome;
		this.descricao = descricao;
		this.usuario = usuario;
	}

	@Id
	@Column(name = "id_comando")
	@GeneratedValue(generator = "comando", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nr_comando", nullable = false)
	private int numero;
	
	@Column(name = "nm_comando", length = 30, nullable = false)
	private String nome;
	
	@Column(name = "ds_descricao", length = 100, nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	@Override
	public String toString() {
		return "\nNumero: " + this.getNumero()
			+ "\nNome: " + this.getNome()
			+ "\nDescricao: " + this.getDescricao()
			+ "\nUsuario: " + this.getUsuario().getNome();
	}
}
