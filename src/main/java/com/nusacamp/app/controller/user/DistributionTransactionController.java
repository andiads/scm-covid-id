package com.nusacamp.app.controller.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nusacamp.app.entity.DistributionTransaction;
import com.nusacamp.app.entity.Item;
import com.nusacamp.app.entity.ItemBrand;
import com.nusacamp.app.entity.Lab;
import com.nusacamp.app.service.DistributionTransactionService;
import com.nusacamp.app.service.ItemService;
import com.nusacamp.app.service.LabService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/distribution")
@RequiredArgsConstructor
public class DistributionTransactionController {

	private final DistributionTransactionService distribTrxService;
	
	private final ItemService itemService;
	
	private final LabService labService;
	
	@GetMapping
	public String index() {
		return "redirect:/distribution/1";
	}
	
	@GetMapping(value = "/{pageNumber}")
	public String listDistrib(@PathVariable Integer pageNumber, Model model) {
		Page<DistributionTransaction> page = distribTrxService.getList(pageNumber);
		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());
		model.addAttribute("list", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		return "distribution/list";
	}
	
	@GetMapping("/add")
	public String addDistibution(Model model) {
		List<Item> item = itemService.getAllItem();
		List<Lab> lab = labService.getAllLabs();
		model.addAttribute("item", item);
		model.addAttribute("lab", lab);
		model.addAttribute("distribtrx", new DistributionTransaction());
		return "distribution/form";
	}
	
	@PostMapping("/save")
	public String saveDistribution(DistributionTransaction distribTrx) {
		distribTrxService.saveDistribTrans(distribTrx);
		return"redirect:/distribution";
	}
	
	@GetMapping("/edit/{idDistribution}")
	public String editDistribution(@PathVariable int idDistribution, Model model) {
		model.addAttribute("distribtrx", distribTrxService.getDistribTrx(idDistribution));
		return"distribution.form";
	}
	
}
