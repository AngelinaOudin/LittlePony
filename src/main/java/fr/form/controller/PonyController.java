package fr.form.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.form.dao.PonyRepository;
import fr.form.exception.ResourceNotFoundException;
import fr.form.littlePony.Pony;

@RestController
@RequestMapping("/api/ponies")
public class PonyController {

	@Autowired
	PonyRepository repository;
	
	@GetMapping("/{id}")
	public Optional<Pony> get(@PathVariable(value = "id") long id) {
		return repository.findById(id);
	}
	
	@GetMapping("/")
	public List<Pony> getAll(){
		return (List<Pony>) repository.findAll();
	}
	
	@PostMapping("/")
	public Pony insert(@RequestBody Pony pony) {
		return repository.save(pony);
	}
	
	@PutMapping("/{id}")
	public Pony update(@PathVariable(value = "id") long id, @RequestBody Pony pony) {
		Pony p = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pony", "id", id));
		p.setName(pony.getName());
		p.setWeight(pony.getWeight());
		p.setAge(pony.getAge());
		p.setColor(pony.getColor());
		Pony ponyUp = repository.save(p);
		return ponyUp;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		repository.deleteById(id);
	}
}
