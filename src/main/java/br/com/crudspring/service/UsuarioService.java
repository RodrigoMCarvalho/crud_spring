package br.com.crudspring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.crudspring.dao.UsuarioDAO;
import br.com.crudspring.model.Usuario;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO dao;
	
	public void salvar(Usuario usuario) {
		dao.save(usuario);
	}
	
	public Iterable<Usuario> buscarTodos(){
		return dao.findAll();
	}
	
	public Optional<Usuario> buscarPorId(Long id){
		 Optional<Usuario> usuario = dao.findById(id);
		 return usuario;
	}
	
	public void excluirPorId(Long id) {
		dao.deleteById(id);
	}
}
