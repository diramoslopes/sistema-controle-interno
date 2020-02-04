package br.com.faespsenar.controleinterno.controller;

import java.util.Arrays;
import java.util.List;

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

import br.com.faespsenar.controleinterno.enumerator.TipoAndar;
import br.com.faespsenar.controleinterno.enumerator.TipoEntidade;
import br.com.faespsenar.controleinterno.model.Departamento;
import br.com.faespsenar.controleinterno.repository.filter.DepartamentoFilter;
import br.com.faespsenar.controleinterno.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	private static final String CADASTRO_VIEW = "CadastroDepartamento";
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Departamento());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Departamento departamento, Errors errors, RedirectAttributes attributes) {
		
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		departamentoService.salvar(departamento);
		
		attributes.addFlashAttribute("mensagem", "Departamento salvo com sucesso!");
		return "redirect:/departamentos/novo";
	}
	
//	@RequestMapping
//	public ModelAndView pesquisar() {
//		
//		List<Departamento> todosDepartamentos = departamentos.findAll();
//		
//		ModelAndView mv = new ModelAndView("PesquisaDepartamento");
//		mv.addObject("departamentos", todosDepartamentos);
//		
//		return mv;
//	}
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") DepartamentoFilter filtro) {
		List<Departamento> todosDepartamentos = departamentoService.filtrar(filtro);
		
		ModelAndView mv = new ModelAndView("PesquisaDepartamento");
		mv.addObject("departamentos", todosDepartamentos);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Departamento departamento) { //por debaixo dos panos o spring faz um findById com o codigo
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(departamento);
		
		return mv;
	}
	
	@RequestMapping(value="/excluir/{codigo}")
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		
		departamentoService.excluir(codigo);
		
		attributes.addFlashAttribute("mensagem", "Departamento excluido com sucesso");
		return "redirect:/departamentos";
	}
	
	@ModelAttribute("todosAndares")
	public List<TipoAndar> todosAndares(){
		return Arrays.asList(TipoAndar.values());
	}
	
	@ModelAttribute("todasEntidades")
	public List<TipoEntidade> todaEntidades(){
		return Arrays.asList(TipoEntidade.values());
	}
	
}