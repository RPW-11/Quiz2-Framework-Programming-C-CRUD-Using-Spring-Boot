package com.quiz2.quiz2.controller;
import java.util.List;

import com.quiz2.quiz2.model.Product;
import com.quiz2.quiz2.model.User;
import com.quiz2.quiz2.repo.ProductRepo;
import com.quiz2.quiz2.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
	// user repo for handler
	@Autowired // automatically create an instace and inject it into the class
	private UserRepo userRepo;
	@Autowired
	private ProductRepo productRepo;


	// map to home
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/register")
	public String viewRegisterPage(Model model){
		model.addAttribute("user", new User());
		return "register_form";
	}

	// handler
	@PostMapping("/process_register")
	public String processRegistration(User user){
		// encrypt password
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPass = encoder.encode(user.getPassword());
		user.setPassword(encodedPass);
		userRepo.save(user);
		return "register_success";
	} 

	@GetMapping("/list_users")
	public String viewUsersList(Model model){
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}

	@GetMapping("/list_products")
	public String viewBooksList(Model model){
		List<Product> listProducts = productRepo.findAll();
		model.addAttribute("listBooks", listProducts);
		return "products";
	}

	@GetMapping("/add_book")
	public String viewAddBookForm(Model model){
		model.addAttribute("product", new Product());
		return "addbookform";
	}

	@PostMapping("/process_addbook")
	public String processAddBook(Product product){
		productRepo.save(product);
		return "redirect:/list_products";
	}

	@GetMapping("/update_book/{id}")
	public String viewUpdateBookForm(@PathVariable(value = "id")Long id, Model model){
		// get product
		Product product = productRepo.getById(id);
		model.addAttribute("product", product);
		return "updatebookform";
	}

	@GetMapping("/delete_book/{id}")
	public String deleteBook(@PathVariable(value = "id")Long id){
		// delete method from repo
		productRepo.deleteById(id);
		return "redirect:/list_products";
	}
}
