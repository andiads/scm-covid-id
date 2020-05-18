package com.nusacamp.app.controller.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nusacamp.app.entity.Item;
import com.nusacamp.app.entity.Lab;
import com.nusacamp.app.entity.StockOrder;
import com.nusacamp.app.entity.StockSource;
import com.nusacamp.app.entity.ViewDistributionList;
import com.nusacamp.app.service.StockSourceService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/stocksource")
@RequiredArgsConstructor
public class StockSourceController {

	private final StockSourceService stockSourceService;
	
	@GetMapping
	public String index() {
		return "redirect:/stocksource/1";
	}
	
	@GetMapping(value = "/{pageNumber}")
	public String listSource(@PathVariable Integer pageNumber, Model model) {
		Page<StockSource> page = stockSourceService.getList(pageNumber);
		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());
		model.addAttribute("list", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		return "stocksource/list";
	}
	
	@GetMapping("/add")
	public String addSource(Model model) {
		model.addAttribute("stocksource", new StockSource());
		return "stocksource/form";
	}
	
	@PostMapping("/save")
	public String saveSource(StockSource stockSource) {
		stockSourceService.saveStockSource(stockSource);
		return"redirect:/stocksource";
	}
	
	@GetMapping("/edit/{idSource}")
	public String editDistribution(@PathVariable int idSource, Model model) {
		model.addAttribute("stocksource", stockSourceService.getStockSource(idSource));
		return"stocksource/form";
	}
}
