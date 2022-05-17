package br.com.desafio.officer.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.officer.entidades.Usuario;
import br.com.desafio.officer.repositorio.UsuarioRepositorio;
import lombok.AllArgsConstructor;

/**
 * Implementação do Cadastro usuário com o retorno de um repositório.
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Service
@AllArgsConstructor
public class UsuarioServicoImpl implements UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;

	@Override
	public Usuario salvar(Usuario login) throws Exception {
		if (login.getId() != null) {
			Usuario loginSalvo = repositorio.findById(login.getId())
					.orElseThrow(() -> new Exception("USUÁRIO NÃO ENCONTRADO!"));
		}
		validarDados(login);
		return repositorio.save(login);
	}

	@Override
	public void excluir(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("VOCÊ PRECISA INFORMAR O ID PARA EXCLUIR!");
		}
		Usuario usuarioExistente = repositorio.usuarioExistentePorPessoa(id);
		if (usuarioExistente != null) {
			throw new Exception("ESTA PESSOA POSSUI UM USUÁRIO! VOCÊ NÃO PODE EXCLUIR!");
		}
		repositorio.deleteById(id);
	}

	@Override
	public boolean login(String usuario, String senha) throws Exception {
		if (usuario.isEmpty() || senha.isEmpty()) {
			throw new Exception("DADOS NÃO PODEM SER VAZIOS");
		}
		Usuario usuarioSalvo = repositorio.buscarPorLogin(usuario);
		if (usuarioSalvo == null) {
			throw new Exception("USUÁRIO OU SENHA INVÁLIDA!");
		}
		boolean permiteEntrarSistema = usuarioSalvo.getSenha().equalsIgnoreCase(senha);
		if (!permiteEntrarSistema) {
			throw new Exception("USUÁRIO OU SENHA INVÁLIDA!");
		}
		return permiteEntrarSistema;
	}

	private void validarDados(Usuario login) throws Exception {
		if (login.getPessoa() == null) {
			throw new Exception("VOCÊ PRECISA INFORMAR A PESSOA");
		} else {
			Usuario usuarioExistentePorPessoa = repositorio.usuarioExistentePorPessoa(login.getPessoa().getId());
			if (usuarioExistentePorPessoa != null) {
				if (login.getId() == null) {
					throw new Exception("ESTA PESSOA JÁ POSSUI USUÁRIO! ");
				} else if (login.getId() != usuarioExistentePorPessoa.getId())
					throw new Exception("PESSOA JÁ POSSUI USUÁRIO!");
			}
		}

		if (login.getNome() == null) {
			throw new Exception("NOME NÃO PODE SER VAZIO!");
		}
		if (login.getUsuario() == null) {
			throw new Exception("O USUÁRIO NÃO PODE SER VAZIO!");
		}

		Usuario existente = repositorio.buscarPorLogin(login.getUsuario());
		if (existente != null) {
			if (login.getId() == null) {
				throw new Exception("O USUÁRIO JÁ EXISTE! ");
			}else {
				if (login.getId() != existente.getId()) {
					throw new Exception("O USUÁRIO JÁ EXISTE! ");
				}
			}
		}
		if (login.getSenha() == null) {
			throw new Exception("SENHA NÃO PODE SER VAZIO!");
		}

	}
}
