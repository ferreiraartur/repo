package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cidade;


@Controller
public class CidadeController {
	
	
	@RequestMapping("/cidades/novo")
	public String novo(Cidade cidade) {
		//model.addAttribute(new cidade());
		return "cidade/CadastroCidade";
	}
	
	
	@RequestMapping(value = "/cidades/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cidade cidade, BindingResult result,Model model, RedirectAttributes attributes){
		
		if (result.hasErrors()) {
			//model.addAttribute(cidade);
			return novo(cidade);
			
		}
		attributes.addFlashAttribute("mensagem", "cidade salva com sucesso!");
		return "redirect:/cidades/novo";
	}
	
	
	
	

}
