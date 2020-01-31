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
import br.com.faespsenar.controleinterno.enumerator.TipoEquipamento;
import br.com.faespsenar.controleinterno.enumerator.TipoStatus;
import br.com.faespsenar.controleinterno.model.Departamento;
import br.com.faespsenar.controleinterno.model.Equipamento;
import br.com.faespsenar.controleinterno.model.Funcionario;
import br.com.faespsenar.controleinterno.repository.Departamentos;
import br.com.faespsenar.controleinterno.repository.Equipamentos;
import br.com.faespsenar.controleinterno.repository.Funcionarios;
import br.com.faespsenar.controleinterno.service.EquipamentoService;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {
	
	private static final String CADASTRO_VIEW = "CadastroEquipamento";
	
	@Autowired
	private Equipamentos equipamentos;
	
	@Autowired
	private Funcionarios funcionarios;
	
	@Autowired
	private Departamentos departamentos;
	
	@Autowired
	private EquipamentoService equipamentoService;
	
	@RequestMapping("/novo") 
	public ModelAndView novo() { 
		ModelAndView mv= new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Equipamento());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Equipamento equipamento, Errors errors, RedirectAttributes attributes) {
		
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		equipamentoService.salvar(equipamento);
		
		attributes.addFlashAttribute("mensagem", "Equipamento salvo com sucesso!");
		return "redirect:/equipamentos/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Equipamento> todosEquipamentos = equipamentos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaEquipamento");
		mv.addObject("equipamentos", todosEquipamentos);
		
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Equipamento equipamento) {//por debaixo dos panos o spring faz um findById com o codigo
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(equipamento);
		return mv;
	}
	
	@RequestMapping(value="/excluir/{codigo}")
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		
		equipamentoService.excluir(codigo);
		
		attributes.addFlashAttribute("mensagem", "Equipamento excluido com sucesso");
		return "redirect:/equipamentos";
	}
	
	@ModelAttribute("todosDepartamentos")
	public List<Departamento> todosDepartamentos(){
		return departamentos.findAll();
	}
	
	@ModelAttribute("todosFuncionarios")
	public List<Funcionario> todosFuncionarios(){
		return funcionarios.findAll();
	}
	
	@ModelAttribute("todasEntidades")
	public List<TipoEntidade> todaEntidades(){
		return Arrays.asList(TipoEntidade.values());
	}
	
	@ModelAttribute("todosTipoEquipamento")
	public List<TipoEquipamento> todosTipoEquipamento(){
		return Arrays.asList(TipoEquipamento.values());
	}
	
	@ModelAttribute("todosTipoStatus")
	public List<TipoStatus> todosTipoStatus(){
		return Arrays.asList(TipoStatus.values());
	}
}
