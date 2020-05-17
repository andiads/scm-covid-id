package com.nusacamp.app.controller.user;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nusacamp.app.entity.ItemDistributor;
import com.nusacamp.app.service.ItemDistributorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/distributor")
@RequiredArgsConstructor
public class ItemDistributorController {

	private final ItemDistributorService itemDistribService;
	
	@GetMapping
	public String index() {
		return"redirect:/distributor/1";
	}
	
	@GetMapping(value = "/{pageNumber}")
	public String listUser(@PathVariable Integer pageNumber, Model model) {
		Page<ItemDistributor> page = itemDistribService.getList(pageNumber);

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());

		model.addAttribute("list", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		return "itemdistributor/list";

	}
	
	@RequestMapping("/add")
	public String addDistrib(Model model) {
		model.addAttribute("itemdis", new ItemDistributor());
		return "itemdistributor/form";
	}
	
	@PostMapping("/save")
	public String saveDistrib(ItemDistributor itemDistributor) {
		itemDistribService.saveItemDistributor(itemDistributor);
		return "redirect:/distributor";
	}
	
	@GetMapping("/edit/{idDistributor}")
	public String editDistrib(@PathVariable int idDistributor, Model model) {
		model.addAttribute("itemdis", itemDistribService.getItemDistributor(idDistributor));
		return "itemdistributor/form";
	}
	
}
