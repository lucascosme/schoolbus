package br.com.lucassolutions.schoolbus.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lucassolutions.schoolbus.facade.ContactFacade;
import br.com.lucassolutions.schoolbus.model.Contact;
import br.com.lucassolutions.schoolbus.model.Message;
import br.com.lucassolutions.schoolbus.model.MessageKey;

@Controller
@RequestMapping("/controller/user")
public class ContactController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

	
	@Autowired private ContactFacade contactFacade;

	@RequestMapping("/screenContact")
	public String screenContact(ModelMap model) {
		return "screenContact";
	}

	@RequestMapping("/saveContactView")
	public String saveContacView(){
		return "registerContact";
	}

	@RequestMapping("/demandContact")
	public String demandContact(ModelMap model, @RequestParam("contactName") String contactName) {
		try {
			if (contactName.isEmpty()) {
				model.addAttribute(MessageKey.ERROR.getKey(), Message.NAME_CONTACT_IS_EMPTY.getKey());
			} else {
				List<Contact> listContacts = contactFacade.demandContact(contactName);
				model.addAttribute("listContacts", listContacts);
				model.addAttribute("listSizeSearch", listContacts.size());
				if (listContacts.size() == 0) {
					model.addAttribute(MessageKey.WARNING.getKey(), Message.NOT_FOUND_CONTACT.getKey());
				}
			}
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.SEARCH_CONTACT_ERROR.getKey());
			LOGGER.info("ERRO AO BUSCAR CONTATO, EXCEPTION: " + e);
		}
		return screenContact(model);
	}
	
	@RequestMapping("/demandContactAll")
	public String demandContactAll(ModelMap model){
		try {
			List<Contact> listContacts = contactFacade.getContacts();
			model.addAttribute("listContacts", listContacts);
			model.addAttribute("listSize", listContacts.size());
			if (listContacts.size() == 0){
				model.addAttribute(MessageKey.WARNING.getKey(), Message.DONT_HAVE_CONTACT.getKey());
			}
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.SEARCH_CONTACT_ERROR.getKey());
		}
		return screenContact(model);
	}
	
	
	@RequestMapping("/saveContact")
	public String saveContact(ModelMap model,@RequestParam("contactName")String contactName,
	@RequestParam("site")String site, @RequestParam("email")String email, 
	@RequestParam("telephone")String telephone,@RequestParam("celphone")String celphone, 
	@RequestParam("address")String address,	@RequestParam("neighborhood")String neighborhood, 
	@RequestParam("city")String city, @RequestParam("state")String state){
		try {
			contactFacade.saveContact(contactName,site,email,telephone,celphone,address,neighborhood,city,state);
			model.addAttribute(MessageKey.SUCESS.getKey(), Message.SAVE_CONTACT_SUCSESSFUL.getKey());
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.SAVE_CONTACT_ERROR.getKey());
		}
		return screenContact(model);
	}
	
	@RequestMapping("/deleteContact")
	public String deleteContact(ModelMap model, @RequestParam("contactId") Long contactId) {
		try {
			contactFacade.disableContact(contactId);
			model.addAttribute(MessageKey.SUCESS.getKey(), Message.DELETE_CONTACT_SUCCESSFUL.getKey());
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.DELETE_CONTACT_ERROR.getKey());
			LOGGER.info("ERRO AO DELETAR CONTATO, EXCEPTION: " + e);
		}
		return screenContact(model);
	}
}
