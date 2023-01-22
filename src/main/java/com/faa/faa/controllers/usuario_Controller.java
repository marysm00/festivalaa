package com.faa.faa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.faa.faa.entities.usuario;
import com.faa.faa.services.usuario_service;

@Controller
public class usuario_Controller {

	@Autowired
	usuario_service usuServ;

	@GetMapping("/listar_usuarios")
	public String listar_usuarios(Model mv) {

		mv.addAttribute("usuarios", usuServ.findAll());
		return "usuario";

	}

	@GetMapping("/addUsuario")
	public String add_usuarios(Model mv) {
		usuario usuario = new usuario();

		mv.addAttribute("usuario", usuario);
		return "add_usuario";
	}

	@PostMapping("/guardar_usuario")
	public String addusuario(@ModelAttribute("usuario") usuario usuario) {

		usuServ.save(usuario);

		return "redirect:/listar_usuarios";
	}

	@GetMapping("/delete_usuario")
	public String delete(@RequestParam("id_usuario") Long id) {

		usuServ.deleteById(id);

		return "redirect:/listar_usuarios";
	}

	@GetMapping("/editarUsu/{id_usuario}")
	public String showUpdateForm(@PathVariable("id_usuario") Long id_usuario, Model mw) {
		final usuario usuario = usuServ.findById(id_usuario);

		mw.addAttribute("usuario", usuario);
		return "edit_usuario";
	}

	@RequestMapping("/editar-usuario/{id}")
	public String updateBook(@PathVariable("id_usuario") Long id_usuario, usuario usuario, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			usuario.setId_usuario(id_usuario);
			return "edit_usuario";
		}

		usuServ.update(usuario);
		model.addAttribute("usuario", usuServ.findAll());
		return "redirect:/listar_usuarios";
	}
	
	@GetMapping(path = { "/buscar_usuario" })
	public String buscar_jurado(usuario u, Model model, String keyword) {
		if (keyword != null) {
			List<usuario> usuarios = usuServ.findBynombre(keyword);
			model.addAttribute("usuarios", usuarios);
		} else {
			List<usuario> usuarios = usuServ.findAll();
			model.addAttribute("usuarios", usuarios);
		}
		return "usuario";
	}

}
