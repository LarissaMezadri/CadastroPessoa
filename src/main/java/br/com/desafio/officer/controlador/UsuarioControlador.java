package br.com.desafio.officer.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.officer.entidades.Usuario;
import br.com.desafio.officer.entidades.dto.UsuarioDTO;
import br.com.desafio.officer.servicos.UsuarioServico;

@RestController
public class UsuarioControlador {

	@Autowired
	private UsuarioServico servico;

	@PostMapping("usuario/login")
	public boolean login(@RequestBody UsuarioDTO usuario) throws Exception {
		return servico.login(usuario.getLogin(), usuario.getSenha());
	}

	@PostMapping("usuario")
	public Usuario salvar(@RequestBody Usuario usuario) throws Exception {
		return servico.salvar(usuario);
	}

	@PutMapping("usuario")
	public Usuario editar(@RequestBody Usuario usuario) throws Exception {
		return servico.salvar(usuario);
	}

	@DeleteMapping("usuario/{id}")
	public void excluir(@PathVariable Integer id) throws Exception {
		servico.excluir(id);

	}
}
