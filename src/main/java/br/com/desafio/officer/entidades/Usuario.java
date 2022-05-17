package br.com.desafio.officer.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entidade responsável pelo cadastro de usuário
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */
@Entity
@Table(name = "cadastrousuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn (name = "ID_cadastrousuario")
	private Pessoa pessoa;

	@Column(name = "nome", nullable = false, length = 100)
	private String nome;

	@Column(name = "usuario", nullable = false, length = 200)
	private String usuario;

	@Column(name = "senha", nullable = false, length = 200)
	private String senha;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the cadastropessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	/**
	 * @param cadastropessoa the cadastropessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @param id
	 * @param cpf
	 * @param usuario
	 * @param senha
	 */
	public Usuario(Integer id, String nome, String usuario, String senha, Pessoa pessoa) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.pessoa = pessoa;
	}

	/**
	 * 
	 */
	public Usuario() {
	}
	

}