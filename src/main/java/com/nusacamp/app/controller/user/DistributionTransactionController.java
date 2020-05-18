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
import com.nusacamp.app.entity.ItemBrand;
import com.nusacamp.app.entity.Lab;
import com.nusacamp.app.entity.StockOrder;
import com.nusacamp.app.entity.StockSource;
import com.nusacamp.app.entity.ViewDistributionList;
import com.nusacamp.app.service.ItemService;
import com.nusacamp.app.service.LabService;
import com.nusacamp.app.service.StockOrderService;
import com.nusacamp.app.service.StockSourceService;
import com.nusacamp.app.service.ViewDistributionListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/distribution")
@RequiredArgsConstructor
public class DistributionTransactionController {

	
	private final ItemService itemService;
	
	private final LabService labService;
	
	private final ViewDistributionListService viewDistributionListService;
	
	private final StockOrderService stockOrderService;
	
	private final StockSourceService stockSourceService;
	
	@GetMapping
	public String index() {
		return "redirect:/distribution/1";
	}
	
	@GetMapping(value = "/{pageNumber}")
	public String listDistrib(@PathVariable Integer pageNumber, Model model) {
		Page<ViewDistributionList> page = viewDistributionListService.getAvailableList(pageNumber);
		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());
		model.addAttribute("list", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		return "distribution/list";
	}
	
	@GetMapping("/inbox")
	public String indexInbox() {
		return "redirect:/distribution/inbox/1";
	}

	@GetMapping(value = "/inbox/{pageNumber}")
	public String inboxDistrib(@PathVariable Integer pageNumber, Model model) {
		Page<ViewDistributionList> page = viewDistributionListService.getAvailableList(pageNumber);
		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());
		model.addAttribute("list", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		return "distribution/inbox";
	}
	
	@GetMapping("/add")
	public String addDistibution(Model model) {
		List<Item> item = itemService.getAllAvailableItems();
		List<Lab> lab = labService.getAllLabs();
		List<StockSource> source = stockSourceService.getAllAvailableSources();
		model.addAttribute("item", item);
		model.addAttribute("lab", lab);
		model.addAttribute("source", source);
		model.addAttribute("distribtrx", new StockOrder());
		return "distribution/form";
	}
	
	@PostMapping("/save")
	public String saveDistribution(StockOrder stockOrder) {
		stockOrderService.saveStockOrder(stockOrder);
		return"redirect:/distribution";
	}
	
	@PostMapping("/inbox/confirm/save")
	public String saveConfirmDistribution(StockOrder stockOrder) {
		stockOrderService.confirmStockOrder(stockOrder);
		return"redirect:/distribution/inbox";
	}
	
	@GetMapping("/inbox/confirm/{idDistribution}")
	public String confirmDistribution(@PathVariable int idDistribution, Model model) {
		List<Item> item = itemService.getAllAvailableItems();
		List<Lab> lab = labService.getAllLabs();
		List<StockSource> source = stockSourceService.getAllAvailableSources();
		model.addAttribute("item", item);
		model.addAttribute("lab", lab);
		model.addAttribute("source", source);
		model.addAttribute("distribtrx", stockOrderService.getStockOrder(idDistribution));
		return"distribution/confirm";
	}
	
	@GetMapping("/edit/{idDistribution}")
	public String editDistribution(@PathVariable int idDistribution, Model model) {
		List<Item> item = itemService.getAllAvailableItems();
		List<Lab> lab = labService.getAllLabs();
		List<StockSource> source = stockSourceService.getAllAvailableSources();
		model.addAttribute("item", item);
		model.addAttribute("lab", lab);
		model.addAttribute("source", source);
		model.addAttribute("distribtrx", stockOrderService.getStockOrder(idDistribution));
		return"distribution/form";
	}
	
	@GetMapping("/delete/{idDistribution}")
	public String deleteDistribution(@PathVariable int idDistribution, StockOrder stockOrder) {
		stockOrder.setIdStockOrder(idDistribution);
		this.stockOrderService.deleteStockOrder(stockOrder);
		return "redirect:/distribution";
	}
	
	@GetMapping("/inbox/delete/{idDistribution}")
	public String deleteInboxDistribution(@PathVariable int idDistribution, StockOrder stockOrder) {
		stockOrder.setIdStockOrder(idDistribution);
		this.stockOrderService.deleteStockOrder(stockOrder);
		return "redirect:/distribution/inbox";
	}
	
}
