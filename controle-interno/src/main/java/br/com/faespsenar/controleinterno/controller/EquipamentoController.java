package br.com.faespsenar.controleinterno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.faespsenar.controleinterno.enumerator.TipoEntidade;
import br.com.faespsenar.controleinterno.enumerator.TipoEquipamento;
import br.com.faespsenar.controleinterno.enumerator.TipoStatus;
import br.com.faespsenar.controleinterno.model.Equipamento;
import br.com.faespsenar.controleinterno.repository.Departamentos;
import br.com.faespsenar.controleinterno.repository.Equipamentos;
import br.com.faespsenar.controleinterno.repository.Funcionarios;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {
	
	@Autowired
	private Equipamentos equipamentos;
	
	@Autowired
	private Funcionarios funcionarios;
	
	@Autowired
	private Departamentos departamentos;
	
	@RequestMapping("/novo") 
	public ModelAndView novo() { 
		ModelAndView mv= new ModelAndView("CadastroEquipamento");
		mv.addObject("todosDepartamentos", departamentos.findAll());
		mv.addObject("todosFuncionarios", funcionarios.findAll());
		mv.addObject("todasEntidades", TipoEntidade.values());
		mv.addObject("todosTipoEquipamentos", TipoEquipamento.values());
		mv.addObject("todosTipoStatus", TipoStatus.values());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Equipamento equipamento) {
		
		equipamentos.save(equipamento);
		
		ModelAndView mv = new ModelAndView("CadastroEquipamento");
		mv.addObject("mensagem", "Equipamento salvo com sucesso!");
		mv.addObject("todosDepartamentos", departamentos.findAll());
		mv.addObject("todosFuncionarios", funcionarios.findAll());
		mv.addObject("todasEntidades", TipoEntidade.values());
		mv.addObject("todosTipoEquipamentos", TipoEquipamento.values());
		mv.addObject("todosTipoStatus", TipoStatus.values());
		
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Equipamento> todosEquipamentos = equipamentos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaEquipamento");
		mv.addObject("equipamentos", todosEquipamentos);
		
		return mv;
	}
	
}
