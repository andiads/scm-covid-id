package com.nusacamp.app.controller.user;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nusacamp.app.entity.UserType;
import com.nusacamp.app.service.UserTypeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/usertype")
@RequiredArgsConstructor
public class UserTypeController {

	private final UserTypeService userTypeService;
	
	@GetMapping
	public String index() {
		return "redirect:/usertype/1";
	}
	
	@GetMapping(value = "/{pageNumber}")
	public String listUserType(@PathVariable Integer pageNumber, Model model) {
		Page<UserType> page = userTypeService.getList(pageNumber);

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());

		model.addAttribute("list", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		return "usertype/list";

	}
	
	@GetMapping("/add")
	public String addUserType(Model model) {
		model.addAttribute("usertype", new UserType());
		return "usertype/form";
	}
	
	@PostMapping("/save")
	public String saveUserType(UserType userType) {
		userTypeService.saveUserType(userType);
		return"redirect:/usertype";
	}
	
	@GetMapping("edit/{id}")
	public String editUserType(@PathVariable int id, Model model) {
		model.addAttribute("usertype", userTypeService.getUserTypeId(id));
		return"/usertype/form";
	}
}
