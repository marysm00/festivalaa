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

import com.faa.faa.entities.grupo_artistico;
import com.faa.faa.services.grupo_artistico_service;

@Controller
public class grupo_artistico_Controller {

	@Autowired
	grupo_artistico_service gruServ;

	@GetMapping("/listar_grupo_artisticos")
	public String listar_grupo_artisticos(Model mv) {

		mv.addAttribute("grupo_artisticos", gruServ.findAll());
		return "grupo_artistico";

	}

	@GetMapping("/addGrupo_artistico")
	public String add_grupo_artistico(Model mv) {
		grupo_artistico grupo_artistico = new grupo_artistico();

		mv.addAttribute("grupo_artistico", grupo_artistico);
		return "add_grupo_artistico";
	}

	@PostMapping("/guardar_grupo_artistico")
	public String addgrupo_artistico(@ModelAttribute("grupo_artistico") grupo_artistico grupo_artistico) {

		gruServ.save(grupo_artistico);

		return "redirect:/listar_grupo_artisticos";
	}

	@GetMapping("/delete_grupo_artistico")
	public String delete(@RequestParam("id_grupo_artistico") Long id) {

		gruServ.deleteById(id);

		return "redirect:/listar_grupo_artisticos";
	}

	@GetMapping("/editarGru/{id_grupo_artistico}")
	public String showUpdateForm(@PathVariable("id_grupo_artistico") Long id_grupo_artistico, Model mw) {
		final grupo_artistico grupo_artistico = gruServ.findById(id_grupo_artistico);

		mw.addAttribute("grupo_artistico", grupo_artistico);
		return "edit_grupo_artistico";
	}

	@RequestMapping("/editar-grupo_artistico/{id}")
	public String updateBook(@PathVariable("id_grupo_artistico") Long id_grupo_artistico,
			grupo_artistico grupo_artistico, BindingResult result, Model model) {
		if (result.hasErrors()) {
			grupo_artistico.setId_grupo_artistico(id_grupo_artistico);
			return "edit_grupo_artistico";
		}

		gruServ.update(grupo_artistico);
		model.addAttribute("grupo_artistico", gruServ.findAll());
		return "redirect:/listar_grupo_artisticos";
	}

	@GetMapping(path = { "/buscar_grupo_artistico" })
	public String buscar_grupo_artistico(grupo_artistico g, Model model, String keyword) {
		if (keyword != null) {
			List<grupo_artistico> grupo_artisticos = gruServ.findBynombre(keyword);
			model.addAttribute("grupo_artisticos", grupo_artisticos);
		} else {
			List<grupo_artistico> grupo_artisticos = gruServ.findAll();
			model.addAttribute("grupo_artisticos", grupo_artisticos);
		}
		return "grupo_artistico";
	}
}
