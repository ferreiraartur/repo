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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.model.Origem;
import com.algaworks.brewer.model.Sabor;

import repository.Cervejas;
import repository.Estilos;
import service.CadastroCervejaService;

@Controller
public class CervejasController {
	
	@Autowired
	private Cervejas cervejas;
	
	@Autowired
	private Estilos estilos;
	
	@Autowired
	private CadastroCervejaService cadastroCervejaService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);
	
	
	@RequestMapping("/cervejas/novo")
	public ModelAndView novo(Cerveja cerveja) {
		//model.addAttribute(new Cerveja());
		//logger.error("Aqui é um log de error!");
		//logger.info("Aqui é um log nível info");
		//cervejas.findAll();
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores",Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
		
	}
	
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result,Model model, RedirectAttributes attributes){
		
		if (result.hasErrors()) {
			//model.addAttribute(cerveja);
			return novo(cerveja);
			
		}
			
		cadastroCervejaService.salvar(cerveja);
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
	
		return new ModelAndView ("redirect:/cervejas/novo");
	}
	
	
	
	

}
