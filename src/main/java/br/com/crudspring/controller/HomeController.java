package br.com.crudspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.crudspring.model.Usuario;
import br.com.crudspring.service.UsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/")
	public String home(Usuario usuario, Model model) {
		model.addAttribute("usuarios", service.buscarTodos());
		return "home";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Usuario usuario, RedirectAttributes attr) {
		service.salvar(usuario);
		attr.addFlashAttribute("success", "Usuário{a} cadastrado{a} com sucesso!");
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String popularEditar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("usuario", service.buscarPorId(id));
		return "editar";
	}
	
	@PostMapping("/editar")
	public String editar(Usuario usuario, RedirectAttributes attr) {
		service.salvar(usuario);
		attr.addFlashAttribute("success", "Usuário{a} alterado{a} com sucesso!");
		return "redirect:/";
	}
	
	@GetMapping("/deletar/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.excluirPorId(id);
		attr.addFlashAttribute("success", "Usuário{a} excluído{a} com sucesso!");
		return "redirect:/";
		
	}
	
	
	
	
	
	
	
	
}
