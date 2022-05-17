package br.com.desafio.officer.entidades.dto;


public class PessoaDTO {

	private String cpf;
	private String nome;
	
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	 * @param cpf
	 * @param nome
	 */
	public PessoaDTO(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	/**
	 * 
	 */
	public PessoaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
		
}
