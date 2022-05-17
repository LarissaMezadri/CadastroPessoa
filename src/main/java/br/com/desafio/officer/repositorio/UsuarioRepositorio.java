package br.com.desafio.officer.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.desafio.officer.entidades.Usuario;

/**
 * Repositorio que se extende a cadastro de usuario. 
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
	
	@Query("select u from Usuario  u "
			+ " where u.usuario = :login "
			+ " order by u.usuario ")
	Usuario buscarPorLogin(@Param("login") String login);
						
	@Query ("select u from Usuario u "
			+ " where u.pessoa.id = :idPessoa ")
	Usuario usuarioExistentePorPessoa(@Param("idPessoa")Integer idPessoa);
}