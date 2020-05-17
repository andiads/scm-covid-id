package com.nusacamp.app.controller.user;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nusacamp.app.entity.ItemBrand;
import com.nusacamp.app.service.ItemBrandService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("brand")
@RequiredArgsConstructor
public class ItemBrandController {
	
	private final ItemBrandService itemBrandService;
	
	
	@GetMapping
	public String index() {
		return "redirect:brand/1";
	}
	
	@GetMapping(value = "/{pageNumber}")
	public String listUser(@PathVariable Integer pageNumber, Model model) {
		Page<ItemBrand> page = itemBrandService.getList(pageNumber);

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());

		model.addAttribute("list", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		return "itembrand/list";

	}
	
	@RequestMapping("/add")
	public String addBrand(Model model) {
		model.addAttribute("itembrand", new ItemBrand());
		return "itembrand/form";
	}
	
	@PostMapping(value="/save")
	public String saveBrand(ItemBrand itemBrand) {
		itemBrandService.saveItemBrand(itemBrand);
		return "redirect:/brand";
	}
	
	@GetMapping("/edit/{idBrand}")
	public String editBrand(@PathVariable int idBrand, Model model) {
		model.addAttribute("itembrand", itemBrandService.getItemBrand(idBrand));
		return "itembrand/form";
	}

}
