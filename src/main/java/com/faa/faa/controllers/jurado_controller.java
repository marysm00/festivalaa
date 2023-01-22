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

import com.faa.faa.entities.jurado;
import com.faa.faa.services.jurado_service;

@Controller
public class jurado_controller {

	@Autowired
	jurado_service jurServ;

	@GetMapping("/listar_jurados")
	public String listar_jurados(Model mv) {

		mv.addAttribute("jurados", jurServ.findAll());
		return "jurado";

	}

	@GetMapping("/addJurado")
	public String add_jurados(Model mv) {
		jurado jurado = new jurado();

		mv.addAttribute("jurado", jurado);
		return "add_jurado";
	}

	@PostMapping("/guardar_jurado")
	public String addjurado(@ModelAttribute("jurado") jurado jurado) {

		jurServ.save(jurado);

		return "redirect:/listar_jurados";
	}

	@GetMapping("/delete_jurado")
	public String delete(@RequestParam("id_jurado") Long id) {

		jurServ.deleteById(id);

		return "redirect:/listar_jurados";
	}

	@GetMapping("/editarJur/{id_jurado}")
	public String showUpdateForm(@PathVariable("id_jurado") Long id_jurado, Model mw) {
		final jurado jurado = jurServ.findById(id_jurado);

		mw.addAttribute("jurado", jurado);
		return "edit_jurado";
	}

	@RequestMapping("/editar-jurado/{id}")
	public String updateBook(@PathVariable("id_jurado") Long id_jurado, jurado jurado, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			jurado.setId_jurado(id_jurado);
			return "edit_jurado";
		}

		jurServ.update(jurado);
		model.addAttribute("jurado", jurServ.findAll());
		return "redirect:/listar_jurados";
	}
	
	@GetMapping(path = { "/buscar_jurado" })
	public String buscar_jurado(jurado j, Model model, String keyword) {
		if (keyword != null) {
			List<jurado> jurados = jurServ.findBynombre(keyword);
			model.addAttribute("jurados", jurados);
		} else {
			List<jurado> jurados = jurServ.findAll();
			model.addAttribute("jurados", jurados);
		}
		return "jurado";
	}

}
