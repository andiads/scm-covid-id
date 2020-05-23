package com.nusacamp.app.controller.user;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nusacamp.app.entity.Item;
import com.nusacamp.app.entity.StockItem;
import com.nusacamp.app.entity.StockSource;
import com.nusacamp.app.entity.ViewStockItem;
import com.nusacamp.app.service.ItemService;
import com.nusacamp.app.service.StockItemService;
import com.nusacamp.app.service.StockSourceService;
import com.nusacamp.app.service.ViewStockItemService;

import java.util.List;
import java.util.Optional;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;

@Slf4j
@Controller
@RequestMapping("/stock_item")
@RequiredArgsConstructor
public class StockItemController {

	private final StockItemService stockItemService;
	private final ViewStockItemService viewStockItemService;
	private final ItemService itemService;
	private final StockSourceService stockSourceService;
	
	private static Optional<StockItem> stockItems;
	
	@GetMapping
	public String index() {
		return "redirect:/stock_item/1";
	}
	
	@GetMapping(value = "/{pageNumber}")
	public String listStockItem(@PathVariable Integer pageNumber, Model model) {
		Page<ViewStockItem> page = viewStockItemService.getList(pageNumber);
		
		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());
		
		model.addAttribute("list", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		return "stockitem/list";
	}
	
	@GetMapping("/add")
	public String addStockItem(Model model) {
		List<Item> item = this.itemService.getAllAvailableItems();
		List<StockSource> source = this.stockSourceService.getAllAvailableSources();
		
		model.addAttribute("item", item);
		model.addAttribute("stockSource", source);
		model.addAttribute("stockItem", new StockItem());
		return "stockitem/form";
	}
	
	@PostMapping(value = "/save")
	public String saveStockItem(StockItem stockItem) {
		this.stockItemService.save(stockItem);
		return "redirect:/stock_item";
	}
	
	@GetMapping("/edit/{idStockItem}")
	public String editStockItem(@PathVariable int idStockItem, Model model) {
		List<Item> item = this.itemService.getAllAvailableItems();
		List<StockSource> source = this.stockSourceService.getAllAvailableSources();
		
		model.addAttribute("item", item);
		model.addAttribute("stockSource", source);
		model.addAttribute("stockItem", this.stockItemService.getById(idStockItem));
		return "stockitem/form";
	}
	
	@GetMapping("/delete/{idStockItem}")
	public String deleteStockItem(@PathVariable int idStockItem, Model model) {
		model.addAttribute("stockItem", this.stockItemService.getById(idStockItem));
		this.stockItems = this.stockItemService.getById(idStockItem);
		return "stockitem/del";
	}
	
	@GetMapping("/confirmDel")
	public String confirmDeteleStockItem(StockItem stockItem) {
		stockItem.setIdItem(this.stockItems.get().getIdItem());
		this.stockItemService.delete(stockItem);
		return "redirect:/stock_item";
	}
}
