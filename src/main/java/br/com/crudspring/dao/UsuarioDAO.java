package br.com.crudspring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.crudspring.model.Usuario;

@Repository
public interface UsuarioDAO extends CrudRepository<Usuario, Long> {

}
