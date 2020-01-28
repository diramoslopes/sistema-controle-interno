package br.com.faespsenar.controleinterno.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.faespsenar.controleinterno.enumerator.StatusTitulo;
import br.com.faespsenar.controleinterno.model.Titulo;
import br.com.faespsenar.controleinterno.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	private static final String CADASTRO_VIEW = "CadastroTitulo";
	
	@Autowired
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Titulo());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {
		
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		titulos.save(titulo);
		attributes.addFlashAttribute("mensagem", "Titulo salvo com sucesso!");
			return "redirect:/titulos/novo";
	}	
	
	@RequestMapping
	public ModelAndView pesquisar() {
		
		List<Titulo> todosTitulos = titulos.findAll();
		
		ModelAndView mv = new ModelAndView("PesquisaTitulo");
		mv.addObject("titulos", todosTitulos);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Titulo titulo) { 
//		Optional<Titulo> titulo = titulos.findById(codigo);
		
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
//		mv.addObject("titulo", titulo.get());
		mv.addObject(titulo);
		
		return mv;
	}
	
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
	
}
