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

import com.faa.faa.entities.premio;
import com.faa.faa.services.premio_service;

@Controller
public class premio_controller {

	@Autowired
	premio_service preServ;

	@GetMapping("/listar_premios")
	public String listar_premios(Model mv) {

		mv.addAttribute("premios", preServ.findAll());
		return "premio";

	}

	@GetMapping("/addPremio")
	public String add_premios(Model mv) {
		premio premio = new premio();

		mv.addAttribute("premio", premio);
		return "add_premio";
	}

	@PostMapping("/guardar_premio")
	public String addpremio(@ModelAttribute("premio") premio premio) {

		preServ.save(premio);

		return "redirect:/listar_premios";
	}

	@GetMapping("/delete_premio")
	public String delete(@RequestParam("id_premio") Long id) {

		preServ.deleteById(id);

		return "redirect:/listar_premios";
	}

	@GetMapping("/editarPre/{id_premio}")
	public String showUpdateForm(@PathVariable("id_premio") Long id_premio, Model mw) {
		final premio premio = preServ.findById(id_premio);

		mw.addAttribute("premio", premio);
		return "edit_premio";
	}

	@RequestMapping("/editar-premio/{id}")
	public String updateBook(@PathVariable("id_premio") Long id_premio, premio premio, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			premio.setId_premio(id_premio);
			return "edit_premio";
		}

		preServ.update(premio);
		model.addAttribute("premio", preServ.findAll());
		return "redirect:/listar_premios";
	}
	
	@GetMapping(path = { "/buscar_premio" })
	public String buscar_premio(premio p, Model model, String keyword) {
		if (keyword != null) {
			List<premio> premios = preServ.findBynombre(keyword);
			model.addAttribute("premios", premios);
		} else {
			List<premio> premios = preServ.findAll();
			model.addAttribute("premios", premios);
		}
		return "premio";
	}
}
