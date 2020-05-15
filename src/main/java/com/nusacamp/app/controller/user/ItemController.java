package com.nusacamp.app.controller.user;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nusacamp.app.entity.Item;
import com.nusacamp.app.entity.User;
import com.nusacamp.app.service.ItemService;
import com.nusacamp.app.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController {

	private final ItemService itemService;
	
	@GetMapping
	public String index() {
		return "redirect:/items/1";
	}
	
	@GetMapping(value = "/{pageNumber}")
	public String listUser(@PathVariable Integer pageNumber, Model model) {
		Page<Item> page = itemService.getList(pageNumber);

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());

		model.addAttribute("list", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		return "items/list";

	}
	
	@GetMapping("/add")
	public String addUser(Model model) {
		model.addAttribute("items", new Item());
		return "items/form";

	}
	
    @PostMapping(value = "/save")
    public String saveUser(Item item) {
    	itemService.saveItem(item);
        return "redirect:/items";
    }
    
    @GetMapping("/edit/{idItem}")
    public String editUser(@PathVariable int idItem, Model model) {
    	model.addAttribute("items", itemService.getById(idItem));
    	return "items/form";
    }    
}