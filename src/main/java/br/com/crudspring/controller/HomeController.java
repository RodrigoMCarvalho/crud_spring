package br.com.crudspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.crudspring.model.Usuario;
import br.com.crudspring.service.UsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Usuario usuario, RedirectAttributes attr) {
		service.salvar(usuario);
		attr.addFlashAttribute("success", "Usuario cadastrado com sucesso!");
		return "redirect:/";
	}
}
