package ksi.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ksi.spring.Serivces.PublisherService;
import ksi.spring.model.Publisher;

@Controller
public class PublisherController {

	private PublisherService publisherService;
	@Autowired
	public PublisherController(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	
	@RequestMapping("publisher_list")
	public String allPublishers(Model model) {
		List<Publisher> all = publisherService.findAll();
		model.addAttribute("all",all);
		return "publisher_list";
	}
	@RequestMapping("new_publisher")
	public String createPublisher(Model model) {
		Publisher publisher = new Publisher();
		model.addAttribute("publisher",publisher);
		return "new_publisher";
	}
	
	@PostMapping(value = "edit_publisher")
	public String save(@ModelAttribute Publisher publisher) {
		publisherService.save(publisher);
		return "redirect:/publisher_list";
	}
	@PostMapping(value = "save_publisher")
	public String saveEditted(@ModelAttribute Publisher publisher) {
		publisherService.save(publisher);
		return "redirect:/publisher_list";
	}
	
	@RequestMapping("/edit_publisher/{idp}")
	public ModelAndView showEditForm(@PathVariable (name = "idp")  Integer idp) {
		ModelAndView mov = new ModelAndView("edit_publisher");
		Optional<Publisher> pub = publisherService.findById(idp);
		mov.addObject("pub",pub);
		return mov;
	}
	@RequestMapping("/delete_publisher/{idp}")
	public String delete(@PathVariable (name = "idp") Integer idp) {
		publisherService.deleteById(idp);
		return "redirect:/publisher_list";
	}
	public PublisherController() {
		// TODO Auto-generated constructor stub
	}

}
