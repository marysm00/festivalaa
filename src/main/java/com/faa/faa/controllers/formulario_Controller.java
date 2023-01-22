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

import com.faa.faa.entities.formulario;
import com.faa.faa.services.formulario_service;

@Controller
public class formulario_Controller {

	@Autowired
	formulario_service forServ;

	@GetMapping("/listar_formularios")
	public String listar_formularios(Model mv) {

		mv.addAttribute("formularios", forServ.findAll());
		return "formulario";

	}

	@GetMapping("/addFormulario")
	public String add_formularios(Model mv) {
		formulario formulario = new formulario();

		mv.addAttribute("formulario", formulario);
		return "add_formulario";
	}

	@PostMapping("/guardar_formulario")
	public String addformulario(@ModelAttribute("formulario") formulario formulario) {

		forServ.save(formulario);

		return "redirect:/listar_formularios";
	}

	@GetMapping("/delete_formulario")
	public String delete(@RequestParam("id_formulario") Long id) {

		forServ.deleteById(id);

		return "redirect:/listar_formularios";
	}

	@GetMapping("/editarFor/{id_formulario}")
	public String showUpdateForm(@PathVariable("id_formulario") Long id_formulario, Model mw) {
		final formulario formulario = forServ.findById(id_formulario);

		mw.addAttribute("formulario", formulario);
		return "edit_formulario";
	}

	@RequestMapping("/editar-formulario/{id}")
	public String updateBook(@PathVariable("id_formulario") Long id_formulario, formulario formulario,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			formulario.setId_formulario(id_formulario);
			return "edit_formulario";
		}

		forServ.update(formulario);
		model.addAttribute("formulario", forServ.findAll());
		return "redirect:/listar_formularios";
	}

	@GetMapping(path = { "/buscar_formulario" })
	public String buscar_formulario(formulario f, Model model, String keyword) {
		if (keyword != null) {
			List<formulario> formularios = forServ.findBynombre(keyword);
			model.addAttribute("formularios", formularios);
		} else {
			List<formulario> formularios = forServ.findAll();
			model.addAttribute("formularios", formularios);
		}
		return "formulario";
	}
}
