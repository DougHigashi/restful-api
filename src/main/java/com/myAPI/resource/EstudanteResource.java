package com.myAPI.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myAPI.domain.Estudante;
import com.myAPI.repo.EstudanteRepository;


@RestController
@RequestMapping("/estudantes")
public class EstudanteResource {
	
	@Autowired
	private EstudanteRepository estudanteRepo;
	
	@GetMapping
	public List<Estudante> listEstudantes(){
		return estudanteRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Estudante getEstudante(@PathVariable Long id) {
		return estudanteRepo.findById(id).orElse(null);
	}
	
	@PostMapping
	public Estudante postEstudante(@RequestBody Estudante estudante) {
		Estudante estudanteCadastrado = estudanteRepo.save(estudante);
		return estudanteRepo.save(estudanteCadastrado);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEstudante(@PathVariable Long id) {
		estudanteRepo.deleteById(id);
	}
	
}
