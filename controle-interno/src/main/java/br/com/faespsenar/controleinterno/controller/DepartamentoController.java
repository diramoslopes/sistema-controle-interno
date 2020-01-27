package br.com.faespsenar.controleinterno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.faespsenar.controleinterno.enumerator.TipoAndar;
import br.com.faespsenar.controleinterno.enumerator.TipoEntidade;
import br.com.faespsenar.controleinterno.model.Departamento;
import br.com.faespsenar.controleinterno.repository.Departamentos;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private Departamentos departamentos;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroDepartamento");
		mv.addObject("todosAndares", TipoAndar.values());
		mv.addObject("todasEntidades", TipoEntidade.values());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Departamento departamento) {
		
		departamentos.save(departamento);
		
		ModelAndView mv = new ModelAndView("CadastroDepartamento");
		mv.addObject("mensagem", "Departamento salvo com sucesso!");
		mv.addObject("todosAndares", TipoAndar.values());
		mv.addObject("todasEntidades", TipoEntidade.values());
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		
		List<Departamento> todosDepartamentos = departamentos.findAll();
		
		ModelAndView mv = new ModelAndView("PesquisaDepartamento");
		mv.addObject("departamentos", todosDepartamentos);
		
		return mv;
	}
	
}