
package com.nusacamp.app.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nusacamp.app.entity.User;
import com.nusacamp.app.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public String index() {
		return "redirect:/users/1";
	}

	@GetMapping(value = "/{pageNumber}")
	public String listUser(@PathVariable Integer pageNumber, Model model) {
		Page<User> page = userService.getList(pageNumber);

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());

		model.addAttribute("list", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		return "users/list";

	}

	@GetMapping("/add")
	public String addUser(Model model) {
		model.addAttribute("users", new User());
		return "users/form";

	}
	
    @PostMapping(value = "/save")
    public String saveUser(User user) {
    	userService.save(user);
        return "redirect:/users";

    }
        
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable int id, Model model) {
    	model.addAttribute("users", userService.getUser(id));
    	return "users/form";
    }    

}