package br.com.lucassolutions.schoolbus.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lucassolutions.schoolbus.facade.ResponsibleFacade;
import br.com.lucassolutions.schoolbus.model.Message;
import br.com.lucassolutions.schoolbus.model.MessageKey;
import br.com.lucassolutions.schoolbus.model.Responsible;

@Controller
@RequestMapping("/controller/user")
public class ResponsibleController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ResponsibleController.class);
	
	@Autowired ResponsibleFacade responsibleFacade;
	
	@RequestMapping("/showresponsibleView")
	public String showresponsible(){
		return "showResponsible";
	}
	
	@RequestMapping("/registerResponsibleView")
	public String registerResponsibleView(){
		return "registerResponsible";
	}
	
	@RequestMapping("/searchResponsible")
	public String searchResponsible(ModelMap model,@RequestParam("name")String name){
		try {
			if (name.isEmpty()) {
				model.addAttribute(MessageKey.ERROR.getKey(), Message.NAME_IS_EMPTY.getKey());
			} else {
				List<Responsible> listResponsibles = responsibleFacade.getResponsibles(name);
				model.addAttribute("listResponsibles", listResponsibles);
				model.addAttribute("listResponsiblesSize", listResponsibles.size());
				LOGGER.info("QUANTIDADE DE RESPONSAVEIS ENCONTRADOS: "+ listResponsibles.size());
				if (listResponsibles.size() == 0) {
					model.addAttribute(MessageKey.WARNING.getKey(), Message.NOT_FOUND_RESPONSIBLE.getKey());
				}
			}
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.SEARCH_ERROR.getKey());
			LOGGER.info("ERRO AO BUSCAR RESPONSAVEL, EXCEPTION: " + e);
		}
		return showresponsible();
	}

}
