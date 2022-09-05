package br.com.fiap.jpa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_bigstar_usuario")
@SequenceGenerator(name = "usuario", sequenceName = "sq_t_bigstar_usuario", allocationSize = 1)
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 496363751778298271L;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, int grauDificuldade) {
		this.nome = nome;
		this.grauDificuldade = grauDificuldade;
	}

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nm_usuario", length = 30, nullable = false)
	private String nome;
	
	@Column(name = "nr_grau", nullable = false)
	private int grauDificuldade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getGrauDificuldade() {
		return grauDificuldade;
	}

	public void setGrauDificuldade(int grauDificuldade) {
		this.grauDificuldade = grauDificuldade;
	}
	
	@Override
	public String toString() {
		return "\nNome: " + this.getNome()
			+ "\nGrauDificuldade: " + this.getGrauDificuldade();
	}

}
