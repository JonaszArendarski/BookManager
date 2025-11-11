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

import ksi.spring.Serivces.CategoryService;
import ksi.spring.model.Category;

@Controller
public class CategoryController {

	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
		
	}
	
	@RequestMapping("new_category")
	public String newCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category",category);
		return "new_category";
	}
	
	@RequestMapping("category_list")
	public String allCategories(Model model){
		List<Category> allCategories = categoryService.findAll();
		model.addAttribute("allCategories" ,allCategories);
		return "category_list";
	}
	@PostMapping(value = "/edit_category")
	public String save(@ModelAttribute Category category) {
		categoryService.save(category);
		return "redirect:/category_list";
	}
	
	@PostMapping(value = "/save_category")
	public String saveEdited(@ModelAttribute Category category) {
		categoryService.save(category);
		return "redirect:/category_list";
	}
	@RequestMapping("/edit_category/{idc}")
	public ModelAndView showEditForm(@PathVariable (name = "idc")  Integer idc) {
		ModelAndView lc = new ModelAndView("edit_category");
		Optional<Category> cat = categoryService.findById(idc);
		lc.addObject("cat",cat);
		return lc;
	}
	@RequestMapping("/delete_category/{idc}")
	public String delete(@PathVariable (name = "idc") Integer idc) {
		categoryService.deleteById(idc);
		return "redirect:/category_list";
	}
	public CategoryController() {
		// TODO Auto-generated constructor stub
	}

}
