/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 26, 2022
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Game;
import dmacc.repository.GameRepository;

@Controller
public class WebController {
	@Autowired
	GameRepository repo;

	@GetMapping({ "/", "/viewAll" })
	public String viewAllGames(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewGame(model);
		}
		model.addAttribute("games", repo.findAll());
		return "results";
	}

	@GetMapping("/inputGame")
	public String addNewGame(Model model) {
		Game g = new Game();
		model.addAttribute("newGame", g);
		return "input";
	}

	@PostMapping("/inputGame")
	public String addNewGame(@ModelAttribute Game g, Model model) {
		repo.save(g);
		return viewAllGames(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdateContact(@PathVariable("id") long id, Model model) {
		Game g = repo.findById(id).orElse(null);
		model.addAttribute("newGame", g);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseGame(Game g, Model model) {
		repo.save(g);
		return viewAllGames(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteGame(@PathVariable("id") long id, Model model) {
		Game g = repo.findById(id).orElse(null);
		repo.delete(g);
		return viewAllGames(model);
	}
}
