package com.nusacamp.app.controller.user;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nusacamp.app.entity.Lab;
import com.nusacamp.app.entity.ViewLabsList;
import com.nusacamp.app.service.LabService;
import com.nusacamp.app.service.ViewLabsListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("labs")
@RequiredArgsConstructor
public class LabController {

	private final LabService labService;
	private final ViewLabsListService viewLabsListService;
	
	
	@GetMapping
	public String index() {
		return "redirect:/labs/1";
	}
	
	@GetMapping(value = "/{pageNumber}")
	public String listLabs(@PathVariable Integer pageNumber, Model model) {
//		Page<Lab> page = labService.getList(pageNumber);
		Page<ViewLabsList> page = viewLabsListService.getList(pageNumber);

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());

		model.addAttribute("list", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);

		return "labs/list";

	}
	
	@GetMapping("/add")
	public String addLab(Model model) {
		model.addAttribute("labs", new Lab());
		return "labs/form";

	}
	
    @PostMapping(value = "/save")
    public String saveUser(Lab lab) {
    	labService.saveLabs(lab);
        return "redirect:/labs";
    }
    
    @GetMapping("/edit/{idLab}")
    public String editUser(@PathVariable int idLab, Model model) {
    	model.addAttribute("labs", labService.getLab(idLab));
    	return "labs/form";
    }
    
    @GetMapping("/delete/{idLab}")
    public String deleteLab(@PathVariable int idLab, Model model) {
    	model.addAttribute("labs", labService.getLab(idLab));
    	return "labs/del";
    }
    
    @PostMapping(value = "/confirmDel")
    public String confirmDeleteLab(Lab lab) {
    	lab.setShown(0);
    	labService.saveLabs(lab);
        return "redirect:/labs";
    }
}
