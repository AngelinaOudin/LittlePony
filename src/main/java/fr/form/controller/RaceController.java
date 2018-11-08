package fr.form.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.form.dao.RaceDao;
import fr.form.exception.ResourceNotFoundException;
import fr.form.littlePony.Race;

@RestController
@RequestMapping("/api/races")
public class RaceController {

	@Autowired
	RaceDao repository;

	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	public Optional<Race> get(@PathVariable(value = "id") long id) {
		return repository.findById(id);
	}

	@GetMapping("/")
	@CrossOrigin(origins = "*")
	public List<Race> getAll() {
		return (List<Race>) repository.findAll();
	}

	@PostMapping("/")
	@CrossOrigin(origins = "*")
	public Race insert(@RequestBody Race race) {
		return repository.save(race);
	}

	@PutMapping("/{id}")
	@CrossOrigin(origins = "*")
	public Race update(@PathVariable(value = "id") long id, @RequestBody Race race) {
		Race r = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Race", "id", id));
		r.setLocation(race.getLocation());
		r.setDate(race.getDate());;
		r.setPonies(race.getPonies());
		Race raceUp = repository.save(r);
		return raceUp;
	}

	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*")
	public void delete(@PathVariable(value = "id") long id) {
		repository.deleteById(id);
	}
}
