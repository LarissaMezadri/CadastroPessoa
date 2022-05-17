package br.com.desafio.officer.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.desafio.officer.entidades.Pessoa;


/**
 * Repositorio que se extende a cadastro pessoa. 
 * 
 * @author Larissa.Mezadri.Da.Silva
 *
 */

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer> {
	
	@Query("select c from Pessoa  c "
			+ " where "
			+ " (:nome is null or c.nome like concat('%',:nome,'%')) "
			+ " and (:cpf is null or c.cpf = :cpf) "
			+ " order by c.nome ")
	List<Pessoa> buscarPorFiltros(@Param("nome") String nome,
								 @Param("cpf") String cpf);

}
