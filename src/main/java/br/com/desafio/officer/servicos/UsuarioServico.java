package br.com.desafio.officer.servicos;

import br.com.desafio.officer.entidades.Usuario;

public interface UsuarioServico {

	/**
	 * Inclui ou altera um cadastro de usuário existente
	 * @param UsuarioServico
	 * @return novo cadastro
	 * @throws Exception 
	 */
	Usuario salvar(Usuario login) throws Exception;
	
	/**
	 * Excluir um cadastro
	 * @param id
	 * @throws Exception 
	 */
	void excluir(Integer id) throws Exception;
		
	boolean login (String usuario, String senha) throws Exception;
	
}
