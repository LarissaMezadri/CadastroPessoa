package br.com.desafio.officer.entidades.dto;


public class UsuarioDTO {

	private String login;
	private String senha;
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
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
	 * @param login
	 * @param senha
	 */
	public UsuarioDTO(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	/**
	 * 
	 */
	public UsuarioDTO() {
	}

	
}