package com.pluralsight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.services.ExerciseService;

@Controller
public class MinutesController {
	//inyección de dependencias
	@Autowired
	private ExerciseService exerciseService;

	@RequestMapping(value = "/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {

		System.out.println("exercise: " + exercise.getMinutes() + " min");
		System.out.println("exercise activity: " + exercise.getActivity());

		// el Fordward sirve para "redireccionar sin perder el request actual
//		return "fordward:addMoreMinutes.html"

		// el Redirect si redirecciona perdiendo request
//		return "redirect:addMoreMinutes.html";

		return "addMinutes";

	}

	@RequestMapping(value = "/addMoreMinutes")
	public String addMoreMinutes(@ModelAttribute("exercise") Exercise exercise) {

		System.out.println("more min: " + exercise.getMinutes());

		return "addMoreMinutes";
	}

	@GetMapping("/activities")
	public @ResponseBody List<Activity> findAllActivities() {
		return exerciseService.finAllActivities();
	}

}
