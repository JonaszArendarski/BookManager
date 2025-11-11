package ksi.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ksi.spring.Serivces.BookService;
import ksi.spring.Serivces.CategoryService;
import ksi.spring.Serivces.PublisherService;
import ksi.spring.model.Books;
import ksi.spring.model.Category;
import ksi.spring.model.Publisher;

@Controller
public class BooksController {


	private BookService service;
	private PublisherService publisherService;
	private CategoryService categoryService;
	public BooksController(BookService service,PublisherService publisherService,CategoryService categoryService) {
		this.service = service;
		this.publisherService = publisherService;
		this.categoryService = categoryService;
	}
	

	@RequestMapping("book_list")
	public String viewBooks(Model model) {
		List<Books> lb = service.findByOrderByTitleAsc();
		model.addAttribute("lb",lb);
		return "book_list";
	}
	@GetMapping("new_book")
	public String showFormNewBook(Model model) {
		Books book = new Books();
		model.addAttribute("book",book);
		List<Publisher> publisher = publisherService.findAll();
		List<Category> category = categoryService.findAll();
		model.addAttribute("categories",category);
		model.addAttribute("publishers",publisher);
		return "new_book";
	}
	@PostMapping(value = "/edit_book")
	public String saveEditedBook(@ModelAttribute Books book) {
		service.save(book);
		return "redirect:/book_list";
	}
	
	@PostMapping(value = "/save_book")
	public String saveBook(@ModelAttribute Books book ,Model model) {
		if (book.getPublisher() != null && book.getPublisher().getIdp() != null) {
	        Integer idp = book.getPublisher().getIdp();
	        Optional<Publisher> p = publisherService.findById(idp);
	        p.ifPresent(book::setPublisher); 
	    } else {
	        book.setPublisher(null);
	    }
		if(book.getCategory() != null && book.getCategory().getIdc() != null) {
			Integer idc = book.getCategory().getIdc();
			Optional<Category> c = categoryService.findById(idc);
			c.ifPresent(book::setCategory);
		}
		else {
			book.setCategory(null);
		}
		service.save(book);
		return "redirect:/book_list";
	}
	@RequestMapping("/edit_book/{idb}")
	public ModelAndView showEditFormBook(@PathVariable(name = "idb") Integer idb) {
	 ModelAndView mav = new ModelAndView("edit_book");
	 Optional<Books> eb = service.findById(idb);
	 mav.addObject("book", eb);
	 mav.addObject("publishers",publisherService.findAll());
	 return mav;
	}
	@RequestMapping("/delete_book/{idb}")
	public String deleteBook(@PathVariable(name = "idb") Integer idb) {
	 service.deleteById(idb);
	 return "redirect:/book_list";
	}
	
	// Ksiazki posortowane po tytule
	@RequestMapping("book_list_sort")
	public String booksSortedByTitle(Model model) {
		List<Books> sortedBooks = service.findAllByTitleNativeSQL();
		model.addAttribute("sortedBooks",sortedBooks);
		return "book_list_sort";
	}
}
