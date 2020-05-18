package com.nusacamp.app.controller.user;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nusacamp.app.entity.StockOrder;
import com.nusacamp.app.service.StockOrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("stock")
@RequiredArgsConstructor
public class StockOrderController {


	private final StockOrderService stockOrderService;
	
	
	@GetMapping
	public String index() {
		return "redirect:/stock/1";
	}
	
	@GetMapping(value = "/{pageNumber}")
	public String listStockOrder(@PathVariable Integer pageNumber, Model model) {
		Page<StockOrder> page = stockOrderService.getList(pageNumber);

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());

		model.addAttribute("list", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		return "stock/list";

	}
	
	@GetMapping("/add")
	public String addStockOrder(Model model) {
		model.addAttribute("stock", new StockOrder());
		return "stock/form";

	}
	
    @PostMapping(value = "/save")
    public String saveStockOrder(StockOrder stockOrder) {
    	stockOrderService.saveStockOrder(stockOrder);
        return "redirect:/stock";
    }
    
    @GetMapping("/edit/{idStockOrder}")
    public String editStockOrder(@PathVariable int idStockOrder, Model model) {
    	model.addAttribute("stock", stockOrderService.getStockOrder(idStockOrder));
    	return "stock/form";
    } 
}