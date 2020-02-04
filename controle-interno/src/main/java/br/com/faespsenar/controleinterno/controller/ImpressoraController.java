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

import br.com.faespsenar.controleinterno.enumerator.TipoMarca;
import br.com.faespsenar.controleinterno.model.Departamento;
import br.com.faespsenar.controleinterno.model.Impressora;
import br.com.faespsenar.controleinterno.repository.Departamentos;
import br.com.faespsenar.controleinterno.repository.filter.ImpressoraFilter;
import br.com.faespsenar.controleinterno.service.ImpressoraService;

@Controller
@RequestMapping("/impressoras")
public class ImpressoraController {
	
	private static final String CADASTRO_VIEW = "CadastroImpressora";
	
	@Autowired
	private Departamentos departamentos;
	
	@Autowired
	private ImpressoraService impressoraService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Impressora());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Impressora impressora, Errors errors, RedirectAttributes attributes) {
		
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		impressoraService.salvar(impressora);
		
		attributes.addFlashAttribute("mensagem", "Impressora salva com sucesso!");
		return "redirect:/impressoras/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") ImpressoraFilter filtro) {
		
		List<Impressora> todasImpressoras = impressoraService.filtrar(filtro);
		
		ModelAndView mv = new ModelAndView("PesquisaImpressoras");
		mv.addObject("impressoras", todasImpressoras);
		
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Impressora impressora) {//por debaixo dos panos o spring faz um findById com o codigo
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(impressora);
		
		return mv;
	}
	
	@RequestMapping(value="/excluir/{codigo}")
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		impressoraService.excluir(codigo);
		
		attributes.addFlashAttribute("mensagem", "Impressora excluida com sucesso");
		return "redirect:/impressoras";
	}
	
	@ModelAttribute("todasMarcas")
	public List<TipoMarca> todasMarcas(){
		return Arrays.asList(TipoMarca.values());
	}
	
	
	@ModelAttribute("todosDepartamentos")
	public List<Departamento> todosDepartamentos(){
		return departamentos.findAll();
	}
	
}