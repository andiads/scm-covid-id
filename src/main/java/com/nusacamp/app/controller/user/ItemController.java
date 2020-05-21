package com.nusacamp.app.controller.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nusacamp.app.entity.Item;
import com.nusacamp.app.entity.ItemBrand;
import com.nusacamp.app.entity.ItemCategory;
import com.nusacamp.app.entity.ItemDistributor;
import com.nusacamp.app.entity.Lab;
import com.nusacamp.app.entity.User;
import com.nusacamp.app.entity.ViewItemsList;
import com.nusacamp.app.repository.ItemRepository;
import com.nusacamp.app.service.ItemBrandService;
import com.nusacamp.app.service.ItemCategoryService;
import com.nusacamp.app.service.ItemDistributorService;
import com.nusacamp.app.service.ItemService;
import com.nusacamp.app.service.UserService;
import com.nusacamp.app.service.ViewItemsListService;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;

@Slf4j
@Controller
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController {

	private final ItemRepository itemRepo;
	
	private final ItemService itemService;
	
	private final ItemBrandService itemBrandService;
	
	private final ItemCategoryService itemCategoryService;
	
	private final ItemDistributorService itemDistribService;
	
	// should use viewItemsList to render the view contents?
	private final ViewItemsListService viewItemsListService;

	private static Item items;
	
	@GetMapping
	public String index() {
		return "redirect:/items/1";
	}
	
	@GetMapping(value = "/{pageNumber}")
	public String listItem(@PathVariable Integer pageNumber, Model model) {
		Page<ViewItemsList> page = viewItemsListService.getAllAvailableList(pageNumber);

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
	public String addItem(Model model) {
		List<ItemBrand> itembr =  itemBrandService.getItemBrand();
		List<ItemCategory> itemcat = itemCategoryService.getItemCategory();
		List<ItemDistributor> itemdis = itemDistribService.getItemDistrib();
		model.addAttribute("itemdis", itemdis);
		model.addAttribute("itemcat", itemcat);
		model.addAttribute("itembrand", itembr);
		model.addAttribute("items", new Item());
		return "items/form";

	}
	
    @PostMapping(value = "/save")
    public String saveItem(Item item) {
    	itemService.saveItem(item);
        return "redirect:/items";
    }
    
    @GetMapping("/edit/{idItem}")
    public String editItem(@PathVariable int idItem, Model model) {
    	List<ItemBrand> itembr =  itemBrandService.getItemBrand();
		List<ItemCategory> itemcat = itemCategoryService.getItemCategory();
		List<ItemDistributor> itemdis = itemDistribService.getItemDistrib();
		model.addAttribute("itemdis", itemdis);
		model.addAttribute("itemcat", itemcat);
		model.addAttribute("itembrand", itembr);
    	model.addAttribute("items", itemService.getById(idItem));
    	return "items/form";
    } 
    
    @GetMapping("/delete/{idItem}")
    public String deleteItem(@PathVariable int idItem, Model model) {
    	model.addAttribute("items", this.itemService.getById(idItem));
    	this.items = this.itemService.getById(idItem);
    	return "items/del";
    }
    
    @GetMapping("/confirmDel")
    public String confirmDeleteItem(Item item) {
    	item.setIdItem(this.items.getIdItem());
    	itemService.deleteItem(item);
        return "redirect:/items";
    }
    
}
