package com.jSolutions.controllers.security;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import com.jSolutions.entities.common.User;
import com.jSolutions.entities.security.PermissionsNames;
import com.jSolutions.entities.security.RolePermission;
import com.jSolutions.entities.security.RolePermissionFormData;
import com.jSolutions.services.security.RolePermissionService;
import com.jSolutions.services.security.RoleService;

@Controller
@RequestMapping("/role-permissions")
public class RolePermissionController {


	@Autowired
	MessageSource messageSource;

	@Autowired
	RolePermissionService rolePermissionService;

	@Autowired
	RoleService roleService;

	/*
	 * This method will list all existing rolePermission.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String list(Model model) {
		User user=((CustomWebAuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getUser();
		@SuppressWarnings("unchecked")
		List<RolePermission> entities = (List<RolePermission>) rolePermissionService.getAll(user);
		model.addAttribute("entities", entities);
		return "security/list-role-permissions";
	}

	/*
	 * This method will provide the medium to add a new rolePermission.
	 */
	/*@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String add(Model model) {
		RolePermission entity = new RolePermission();
		model.addAttribute("browserTitle", "Edit roles permissions");
		model.addAttribute("view", "../security/edit-role-permission");
		model.addAttribute("entity", entity);
		model.addAttribute("edit", false);
		User user=((CustomWebAuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getUser();
		model.addAttribute("roles", roleService.getAll(user));
		model.addAttribute("permissionTypes", PermissionsNames.PERMISSIONS_ARR);
		model.addAttribute("entities", PermissionsNames.ENTITIES_ARR);
		System.out.println(model.asMap().get("roles"));
		return "layout/defaultLayout";
	}*/


	/*
	 * This method will be called on form submission, handling POST request for
	 * saving role in database. It also validates the user input
	 */
	/*@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String save(@Valid RolePermission entity, BindingResult result, Model model, RedirectAttributes redir) {
		if (result.hasErrors()) {
			return "security/edit-role-permission";
		}
		User user=((CustomWebAuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getUser();
		boolean isUnique=rolePermissionService.isNameUnique(entity.getEntityName(), user);
		if(!isUnique){
			FieldError ssnError =new FieldError("role","name",messageSource.getMessage("non.unique.name", 
					new String[]{"Role", entity.getEntityName()}, Locale.getDefault()));
			result.addError(ssnError);
			return "security/edit-role-permission";
		}
		rolePermissionService.create(entity, user);
		redir.addFlashAttribute("message", "Role permission " + entity.getEntityName()  + " added successfully");
		return "redirect:/role-permissions/list";
	}*/

	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/{roleId}/edit" }, method = RequestMethod.GET)
	public String edit(@PathVariable int roleId, Model model) {
		User user=((CustomWebAuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getUser();
		model.addAttribute("formEntity", new RolePermission());
		model.addAttribute("entity", roleService.read(roleId, user));
		model.addAttribute("permissionTypes", PermissionsNames.PERMISSIONS_ARR);
		model.addAttribute("entities", PermissionsNames.ENTITIES_ARR);
		model.addAttribute("edit", true);
		model.addAttribute("view", "../security/edit-role-permission");
		return "layout/defaultLayout";
	}


	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/{roleId}/edit" }, method = RequestMethod.POST)
	public String update(@Valid RolePermission entity, BindingResult result,
			Model model, @PathVariable Integer roleId, RedirectAttributes redir) {

		if (result.hasErrors()) {
			return "security/edit-role-permission";
		}
		User user=((CustomWebAuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getUser();
		
		rolePermissionService.sav
		
		RolePermission permission=rolePermissionService.readByNameAndRoleId(entity.getEntityName(), roleId, user);
		if(permission==null) {
			
		}
		
		if(!rolePermissionService.isNameUnique(entity.getEntityName(), user)){
			FieldError nameError =new FieldError("role","name", 
					messageSource.getMessage("non.unique.name", new String[]{"Role permission", entity.getEntityName()}, Locale.getDefault()));
			result.addError(nameError);
			return "security/edit-role-permission";
		}

		rolePermissionService.update(entity, user);
		redir.addFlashAttribute("message", "Role permission " + entity.getEntityName()  + " updated successfully");
		//model.addAttribute("message", "Domain " + domain.getName()  + " updated successfully");
		return "redirect:/role-permissions/list";
	}

	/*
	 * This method will delete a category by it's id value.
	 */
	@RequestMapping(value = { "/{id}/delete" }, method = RequestMethod.GET)
	public String delete(@PathVariable int id, RedirectAttributes redir) {
		User user=((CustomWebAuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getUser();
		rolePermissionService.delete(id, user);
		redir.addFlashAttribute("message", "Role permission with id " + id  + " deleted successfully");
		return "redirect:/role-permissions/list";
	}

}
