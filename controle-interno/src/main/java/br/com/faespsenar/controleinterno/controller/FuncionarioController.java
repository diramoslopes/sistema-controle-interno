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

import br.com.faespsenar.controleinterno.enumerator.TipoEntidade;
import br.com.faespsenar.controleinterno.model.Departamento;
import br.com.faespsenar.controleinterno.model.Funcionario;
import br.com.faespsenar.controleinterno.repository.Departamentos;
import br.com.faespsenar.controleinterno.repository.filter.FuncionarioFilter;
import br.com.faespsenar.controleinterno.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	private static final String CADASTRO_VIEW = "CadastroFuncionario";
	
	@Autowired
	private Departamentos departamentos;
	
	@Autowired 
	private FuncionarioService funcionarioService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Funcionario());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Funcionario funcionario, Errors errors, RedirectAttributes attributes) {
		
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		funcionarioService.salvar(funcionario);
		
		attributes.addFlashAttribute("mensagem", "Funcionario salvo com sucesso!");
		return "redirect:/funcionarios/novo";
	}
	
//	@RequestMapping
//	public ModelAndView pesquisar() {
//		
//		List<Funcionario> todosFuncionarios = funcionarios.findAll();
//		
//		ModelAndView mv = new ModelAndView("PesquisaFuncionario");
//		mv.addObject("funcionarios", todosFuncionarios);
//		
//		return mv;
//	}
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") FuncionarioFilter filtro) {
		
		List<Funcionario> todosFuncionarios = funcionarioService.filtrar(filtro);
		
		ModelAndView mv = new ModelAndView("PesquisaFuncionario");
		mv.addObject("funcionarios", todosFuncionarios);
		
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Funcionario funcionario) {//por debaixo dos panos o spring faz um findById com o codigo
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(funcionario);
		
		return mv;
	}
	
	@RequestMapping(value="/excluir/{codigo}")
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		funcionarioService.excluir(codigo);
		
		attributes.addFlashAttribute("mensagem", "Funcionario excluido com sucesso");
		return "redirect:/funcionarios";
	}
	
	@ModelAttribute("todasEntidades")
	public List<TipoEntidade> todaEntidades(){
		return Arrays.asList(TipoEntidade.values());
	}
	
	@ModelAttribute("todosDepartamentos")
	public List<Departamento> todosDepartamentos(){
		return departamentos.findAll();
	}
	
}