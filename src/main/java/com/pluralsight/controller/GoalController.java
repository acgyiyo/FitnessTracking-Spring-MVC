package com.pluralsight.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pluralsight.model.Goal;

@Controller
//este session attribute va asociado al model attribute : model.addAttribute("goal",goal)
@SessionAttributes("goal")
public class GoalController {

	@GetMapping("/addGoal")
	public String addGoal(Model model) {
		Goal goal = new Goal();
		goal.setMinutes(45);
		model.addAttribute("goal", goal);

		return "addGoal";
	}

	@PostMapping("/addGoal")
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result) {

		System.out.println("Minutes updatedted: " + goal.getMinutes());

		if(result.hasErrors()) {
			return "addGoal";
		}
		
		return "redirect:addMinutes.html";
	}

}
