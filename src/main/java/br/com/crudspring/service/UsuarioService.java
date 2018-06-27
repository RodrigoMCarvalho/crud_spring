package br.com.crudspring.service;

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
}
