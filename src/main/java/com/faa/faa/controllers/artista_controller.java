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

import com.faa.faa.entities.artista;
import com.faa.faa.services.artista_service;

@Controller

public class artista_controller {

	@Autowired
	artista_service artServ;

	@GetMapping("/listar_artistas")
	public String listar_artistas(Model mv) {

		mv.addAttribute("artistas", artServ.findAll());
		return "artista";

	}

	@GetMapping("/addArtista")
	public String add_artistas(Model mv) {
		artista artista = new artista();

		mv.addAttribute("artista", artista);
		return "add_artista";
	}

	@PostMapping("/guardar_artista")
	public String addartista(@ModelAttribute("artista") artista artista) {

		artServ.save(artista);

		return "redirect:/listar_artistas";
	}

	@GetMapping("/delete_artista")
	public String delete(@RequestParam("id_artista") Long id) {

		artServ.deleteById(id);

		return "redirect:/listar_artistas";
	}

	@GetMapping(path = { "/buscar_artista" })
	public String buscar_artista(artista a, Model model, String keyword) {
		if (keyword != null) {
			List<artista> artistas = artServ.findBynombre(keyword);
			model.addAttribute("artistas", artistas);
		} else {
			List<artista> artistas = artServ.findAll();
			model.addAttribute("artistas", artistas);
		}
		return "artista";
	}

	@GetMapping("/editarArt/{id_artista}")
	public String showUpdateForm(@PathVariable("id_artista") Long id_artista, Model mw) {
		final artista artista = artServ.findById(id_artista);

		mw.addAttribute("artista", artista);
		return "edit_artista";
	}

	@RequestMapping("/editar-artista/{id}")
	public String updateBook(@PathVariable("id_artista") Long id_artista, artista artista, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			artista.setId_artista(id_artista);
			return "edit_artista";
		}

		artServ.update(artista);
		model.addAttribute("artista", artServ.findAll());
		return "redirect:/listar_artistas";
	}

}
