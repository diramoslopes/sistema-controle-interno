package br.com.faespsenar.controleinterno.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping("/novo") 
	public ModelAndView novo() { 
		ModelAndView mv= new ModelAndView(CADASTRO_VIEW);
		//mv.addObject("todosDepartamentos", departamentos.findAll());
		//mv.addObject("todosFuncionarios", funcionarios.findAll());
		//mv.addObject("todasEntidades", TipoEntidade.values());
		//mv.addObject("todosTipoEquipamentos", TipoEquipamento.values());
		//mv.addObject("todosTipoStatus", TipoStatus.values());
		mv.addObject(new Equipamento());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Equipamento equipamento, Errors errors, RedirectAttributes attributes) {
		
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		equipamentos.save(equipamento);
		
		//ModelAndView mv = new ModelAndView("CadastroEquipamento");
		//mv.addObject("mensagem", "Equipamento salvo com sucesso!");
		
		attributes.addFlashAttribute("mensagem", "Equipamento salvo com sucesso!");
		//mv.addObject("todosDepartamentos", departamentos.findAll());
		//mv.addObject("todosFuncionarios", funcionarios.findAll());
		//mv.addObject("todasEntidades", TipoEntidade.values());
		//mv.addObject("todosTipoEquipamentos", TipoEquipamento.values());
		//mv.addObject("todosTipoStatus", TipoStatus.values());
		
		return "redirect:/equipamentos/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Equipamento> todosEquipamentos = equipamentos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaEquipamento");
		mv.addObject("equipamentos", todosEquipamentos);
		
		return mv;
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
