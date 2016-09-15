package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cerveja;

import repository.Cervejas;

@Controller
public class CervejasController {
	
	@Autowired
	private Cervejas cervejas;
	
	
	private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);
	
	
	@RequestMapping("/cervejas/novo")
	public String novo(Cerveja cerveja) {
		//model.addAttribute(new Cerveja());
		logger.error("Aqui é um log de error!");
		logger.info("Aqui é um log nível info");
		
		cervejas.findAll();
		
		
		return "cerveja/CadastroCerveja";
	}
	
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result,Model model, RedirectAttributes attributes){
		
		if (result.hasErrors()) {
			//model.addAttribute(cerveja);
			return novo(cerveja);
			
		}
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		return "redirect:/cervejas/novo";
	}
	
	
	
	

}
