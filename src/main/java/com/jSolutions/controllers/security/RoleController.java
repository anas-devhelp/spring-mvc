package com.jSolutions.controllers.security;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jSolutions.configuration.CustomWebAuthenticationDetails;
import com.jSolutions.dao.security.RoleDao;
import com.jSolutions.entities.security.Role;
import com.jSolutions.services.security.RoleService;

@Controller
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	RoleDao roleDao;
	
	/*
	 * This method will list all existing categories.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String list(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		CustomWebAuthenticationDetails authDetails = (CustomWebAuthenticationDetails)auth.getDetails();
		
		System.out.println(">>>>>list>>>>start");
		System.out.println(authDetails);
		System.out.println(">>>>>list>>>>start");
		
		
		
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		@SuppressWarnings("unchecked")
		List<Role> entities = (List<Role>) roleService.getAll(authDetails.getUser());
		model.addAttribute("entities", entities);
		return "security/list-roles";
	}
	
	/*
	 * This method will provide the medium to add a new role.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String add(Model model) {
		Role role = new Role();
		model.addAttribute("role", role);
		model.addAttribute("edit", false);
		return "security/edit-role";
	}
	
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * saving role in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String save(@Valid Role role, BindingResult result, Model model, RedirectAttributes redir) {
		System.out.println("Validating .......");
		if (result.hasErrors()) {
			return "security/edit-role";
		}
		System.out.println("Validation passed");

		/* * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
		 * and applying it on field [ssn] of Model class [Employee].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomWebAuthenticationDetails authDetails = (CustomWebAuthenticationDetails)auth.getDetails();
		boolean isUnique=roleService.isNameUnique(role.getName(), authDetails.getUser());
		System.out.println("Validation passed1");
		System.out.println("isUnique==="+isUnique);
		if(!isUnique){
			System.out.println("Validation passed2");
			FieldError ssnError =new FieldError("role","name",messageSource.getMessage("non.unique.name", 
					new String[]{"Role", role.getName()}, Locale.getDefault()));
			result.addError(ssnError);
			return "security/edit-role";
		}
		role.setStatus(1);
		roleService.create(role, authDetails.getUser());
		System.out.println("Validation passed3");
		redir.addFlashAttribute("message", "Role " + role.getName()  + " added successfully");
		return "redirect:/roles/list";
	}
	
	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/{id}/edit" }, method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomWebAuthenticationDetails authDetails = (CustomWebAuthenticationDetails)auth.getDetails();
		System.out.println("authDetails.getUser()>>>"+authDetails.getUser());
		Role role =(Role) roleService.read(id, authDetails.getUser());
		model.addAttribute("role", role);
		model.addAttribute("edit", true);
		return "security/edit-role";
	}
	
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/{id}/edit" }, method = RequestMethod.POST)
	public String update(@Valid Role role, BindingResult result,
			Model model, @PathVariable String id, RedirectAttributes redir) {

		if (result.hasErrors()) {
			return "security/edit-role";
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomWebAuthenticationDetails authDetails = (CustomWebAuthenticationDetails)auth.getDetails();
		if(!roleService.isNameUnique(role.getName(), authDetails.getUser())){
			FieldError nameError =new FieldError("role","name", 
					messageSource.getMessage("non.unique.name", new String[]{"Role", role.getName()}, Locale.getDefault()));
			result.addError(nameError);
			return "security/edit-role";
		}

		roleService.update(role, authDetails.getUser());
		redir.addFlashAttribute("message", "Role " + role.getName()  + " updated successfully");
		//model.addAttribute("message", "Domain " + domain.getName()  + " updated successfully");
		return "redirect:/roles/list";
	}
	
	/*
	 * This method will delete a category by it's id value.
	 */
	 @RequestMapping(value = { "/{id}/delete" }, method = RequestMethod.GET)
	 public String deleteEmployee(@PathVariable int id, RedirectAttributes redir) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 CustomWebAuthenticationDetails authDetails = (CustomWebAuthenticationDetails)auth.getDetails();
		 roleService.delete(id, authDetails.getUser());
		 redir.addFlashAttribute("message", "Role with id " + id  + " deleted successfully");
		 return "redirect:/roles/list";
	 }
}
