package com.nusacamp.app.controller.user;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nusacamp.app.entity.ItemCategory;
import com.nusacamp.app.entity.ViewItemCategory;
import com.nusacamp.app.service.ItemCategoryService;
import com.nusacamp.app.service.ViewItemCategoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class ItemCategoryController {

	private final ItemCategoryService itemCatService;
	private final ViewItemCategoryService viewItemCatService;
	private static ItemCategory category;
	
	@GetMapping
	public String index() {
		return "redirect:/category/1";
	}
	
	@GetMapping(value = "/{pageNumber}")
	public String listUser(@PathVariable Integer pageNumber, Model model) {
//		Page<ItemCategory> page = itemCatService.getList(pageNumber);
		Page<ViewItemCategory> page = viewItemCatService.getList(pageNumber);

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());

		model.addAttribute("list", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		return "itemcategory/list";

	}
	
	@RequestMapping("/add")
	public String addCategory(Model model) {
		model.addAttribute("itemcat", new ItemCategory());
		return "itemcategory/form";
	}
	
	@PostMapping("/save")
	public String saveCategory(ItemCategory itemCategory) {
		itemCatService.saveItemCategory(itemCategory);
		return "redirect:/category";
	}
	
	@GetMapping("/edit/{idCategory}")
	public String editCategory(@PathVariable int idCategory, Model model) {
		model.addAttribute("itemcat", itemCatService.getItemCategory(idCategory));
		return"itemcategory/form";
	}
	
	@GetMapping("/delete/{idCategory}")
    public String deleteCategory(@PathVariable int idCategory, Model model) {
    	model.addAttribute("itemcat", this.itemCatService.getItemCategory(idCategory));
    	this.category = this.itemCatService.getItemCategory(idCategory);
    	return "itemcategory/del";
    }
    
    @GetMapping("/confirmDel")
    public String confirmDeleteCategory(ItemCategory itemCategory) {
    	category.setIdCategory(this.category.getIdCategory());
    	itemCatService.deleteCategory(category);
        return "redirect:/category";
    }
}
