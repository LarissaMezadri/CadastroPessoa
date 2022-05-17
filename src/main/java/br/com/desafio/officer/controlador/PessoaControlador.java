package br.com.desafio.officer.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.officer.entidades.Pessoa;
import br.com.desafio.officer.entidades.dto.PessoaDTO;
import br.com.desafio.officer.servicos.PessoaServico;


@RestController
public class PessoaControlador {
	
	@Autowired
	private PessoaServico servico;
	
	@GetMapping("pessoa/{id}")
	public Pessoa buscarId(@PathVariable Integer id) throws Exception {
		Pessoa retornar = servico.buscarId(id);
		if (retornar == null) {
			throw new Exception("CADASTRO VÁLIDO!");
		}
		return retornar;
	}
	
	@PostMapping("pessoa")
	public Pessoa salvar(@RequestBody Pessoa pessoa) throws Exception {
		return servico.salvar(pessoa);
	}

	@PutMapping("pessoa")
	public Pessoa editar(@RequestBody Pessoa pessoa) throws Exception {
		return servico.salvar(pessoa);
	}
	
	@DeleteMapping ("pessoa/{id}")
	public void excluir(@PathVariable Integer id) throws Exception {
		servico.excluir(id);
	}
	
	@GetMapping("pessoa/buscarPorFiltros")
	public List<Pessoa> buscarPorFiltros(@RequestBody PessoaDTO cadastroFiltros) throws Exception{
		return servico.buscarPorFiltros(cadastroFiltros);
	}
	
}
