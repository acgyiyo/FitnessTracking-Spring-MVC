package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pluralsight.model.Exercise;

@Controller
public class MinutesController {

	@RequestMapping(value = "/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {

		System.out.println("exercise: " + exercise.getMinutes() + " min");

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
}
