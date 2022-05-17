package br.com.desafio.officer.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.officer.entidades.Pessoa;
import br.com.desafio.officer.entidades.Usuario;
import br.com.desafio.officer.entidades.dto.PessoaDTO;
import br.com.desafio.officer.repositorio.PessoaRepositorio;
import br.com.desafio.officer.repositorio.UsuarioRepositorio;
import lombok.AllArgsConstructor;

/**
 * Implementação do Cadastro pessoas com o retorno de um repositório.
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Service
@AllArgsConstructor
public class PessoaServicoImpl implements PessoaServico {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private PessoaRepositorio repositorio;

	@Override
	public Pessoa salvar(Pessoa cadastro) throws Exception {
		if (cadastro.getId() != null) {
			Pessoa cadastroSalvo = buscarId(cadastro.getId());
			if (cadastroSalvo == null) {
				throw new Exception("CADASTRO NÃO ENCONTRADO!");
			}
		}
		validarDados(cadastro);
		return repositorio.save(cadastro);
	}

	@Override
	public void excluir(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("VOCÊ PRECISA INFORMAR O ID PARA EXCLUIR!");
		}
		Usuario usuarioExistente = usuarioRepositorio.usuarioExistentePorPessoa(id);
		if (usuarioExistente != null) {
			throw new Exception("ESTA PESSOA POSSUI UM USUÁRIO! VOCÊ NÃO PODE EXCLUIR!");
		}
		repositorio.deleteById(id);
	}

	@Override
	public List<Pessoa> buscarPorFiltros(PessoaDTO cadastroFiltros) throws Exception {
		if (cadastroFiltros.getNome() == null || cadastroFiltros.getCpf() == null) {
			throw new Exception("VOCÊ PRECISA INFORMAR NOME E CPF!");
		}
		return repositorio.buscarPorFiltros(cadastroFiltros.getNome(), cadastroFiltros.getCpf());
	}

	@Override
	public Pessoa buscarId(Integer id) throws Exception {
		return repositorio.findById(id).orElse(null);
	}

	@SuppressWarnings("unused")
	private void validarDados(Pessoa cadastro) throws Exception {
		if (cadastro.getCpf() == null) {
			throw new Exception("CPF NÃO PODE SER VAZIO!");
		}
		if (cadastro.getCpf().length() != 14) {
			throw new Exception("O CPF PRECISA CONTER 14 DIGITOS!");
		}
		Pessoa cpfValido = repositorio.buscarPorFiltros(null, cadastro.getCpf()).stream().findFirst().orElse(null);
		if (cpfValido != null) {
			if (cadastro.getId() == null) {
				throw new Exception("O CPF JÁ EXISTE! ");
			} else if (cadastro.getId() != cpfValido.getId())
				throw new Exception("O CPF JÁ EXISTE! ");
		}

		if (cadastro.getNome() == null){
			throw new Exception("NOME NÃO PODE SER VAZIO!");
		}
		if (cadastro.getCep() == null) {
			throw new Exception("CEP NÃO PODE SER VAZIO!");
		}
		if (cadastro.getCep().length() != 10) {
			throw new Exception("O CEP PRECISA CONTER 10 DIGITOS!");
		}
		if (cadastro.getEndereco() == null) {
			throw new Exception("ENDEREÇO NÃO PODE SER VAZIO!");
		}
		if (cadastro.getBairro() == null) {
			throw new Exception("BAIRRO NÃO PODE SER VAZIO!");
		}
		if (cadastro.getMunicipio() == null) {
			throw new Exception("MUNICÍPIO NÃO PODE SER VAZIO!");
		}
		if (cadastro.getUf() == null) {
			throw new Exception("UF NÃO PODE SER VAZIO!");
		}
		if (cadastro.getUf().length() != 2) {
			throw new Exception("O UF PRECISA CONTER 2 DIGITOS! EX: (SC = SANTA CATARINA");
		}
		if (cadastro.getRg() == null) {
			throw new Exception("RG NÃO PODE SER VAZIO!");
		}
	}
}