package br.com.faespsenar.controleinterno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.faespsenar.controleinterno.enumerator.TipoEntidade;
import br.com.faespsenar.controleinterno.model.Funcionario;
import br.com.faespsenar.controleinterno.repository.Departamentos;
import br.com.faespsenar.controleinterno.repository.Funcionarios;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private Funcionarios funcionarios;
	
	@Autowired
	private Departamentos departamentos;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroFuncionario");
		mv.addObject("todosDepartamentos", departamentos.findAll());
		mv.addObject("todasEntidades", TipoEntidade.values());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Funcionario funcionario) {
		
		funcionarios.save(funcionario);
		
		ModelAndView mv = new ModelAndView("CadastroFuncionario");
		mv.addObject("mensagem", "Funcionario salvo com sucesso!");
		mv.addObject("todosDepartamentos", departamentos.findAll());
		mv.addObject("todasEntidades", TipoEntidade.values());
		
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		
		List<Funcionario> todosFuncionarios = funcionarios.findAll();
		
		ModelAndView mv = new ModelAndView("PesquisaFuncionario");
		mv.addObject("funcionarios", todosFuncionarios);
		
		return mv;
		
	}
	
}