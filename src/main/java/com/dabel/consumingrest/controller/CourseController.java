package com.dabel.consumingrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dabel.consumingrest.model.Course;
import com.dabel.consumingrest.service.CourseService;

/**
 * Configure mapping HTTP requests
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	private List<String> listCategories = Arrays.asList(
			"Développement", "Marketing", "Bureautique", "Data");
	
	private List<String> listLevels = Arrays.asList(
			"Facile", "Moyen", "Avancé");
	

	@GetMapping("/404")
	public String errorPage() {
		return "404";
	}
	
	@GetMapping("/")
	public String home(Model model, Course course) {
		
		List<Course> courses = courseService.findAll();
		
		model.addAttribute("courses", courses);
		model.addAttribute("levels", listLevels);
		model.addAttribute("categories", listCategories);
		
		return "index";
	}
	
	@PostMapping("/")
	public String home(@ModelAttribute Course course, RedirectAttributes redirect) {
		
		//check if all informations are correct
		if(course.getTitle().isBlank() || course.getCategory().isBlank() || course.getLevel().isBlank() || course.getDescription().isBlank())
			return "redirect:/?error";
		
		courseService.save(course, false);
		
		String message = "Le cours a bien été ajouté";
		redirect.addFlashAttribute("message", message);
		
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		
		//check if exists course id
		if(!courseService.exists(id)) return "redirect:/404";
		
		Course course = courseService.findById(id);
		
		model.addAttribute("course", course);
		model.addAttribute("levels", listLevels);
		model.addAttribute("categories", listCategories);
		
		return "update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Course course) {
		
		courseService.save(course, true);
		return "redirect:/?updated";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		
		courseService.deleteById(id);
		return "redirect:/?deleted";
	}
}
