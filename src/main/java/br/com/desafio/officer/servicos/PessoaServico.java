package br.com.desafio.officer.servicos;

import java.util.List;

import br.com.desafio.officer.entidades.Pessoa;
import br.com.desafio.officer.entidades.dto.PessoaDTO;

public interface PessoaServico {

	/**
	 * Inclui ou altera um cadastro existente
	 * @param cadastroPessoaServico
	 * @return novo cadastro
	 * @throws Exception 
	 */
	Pessoa salvar(Pessoa pessoa) throws Exception;
	
	/**
	 * Excluir um cadastro
	 * @param id
	 * @throws Exception 
	 */
	void excluir(Integer id) throws Exception;
	
	/**
	 * Lista os cadastros conforme os filtros informados
	 * @param contaFiltros
	 * @return
	 * @throws Exception 
	 */
	List<Pessoa> buscarPorFiltros(PessoaDTO cadastroFiltros) throws Exception;
	
	/**
	 * Busca o cadastro pelo Id informado 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Pessoa buscarId(Integer id) throws Exception;
	
}
