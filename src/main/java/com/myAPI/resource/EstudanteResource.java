package com.myAPI.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/{id}")
	public Estudante atualizarEstudante(@PathVariable("id") Long id,
			@RequestBody Estudante estudante) {
		return estudanteRepo.findById(id).map(
				record -> {
					record.setAge(estudante.getAge());
					record.setCurso(estudante.getCurso());
					record.setName(estudante.getName());
					record.setRa(estudante.getRa());
					return estudanteRepo.save(record);
				}).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEstudante(@PathVariable Long id) {
		Estudante estudanteDeletado = estudanteRepo.findById(id).get();
		estudanteRepo.deleteById(id);
		return "Estudante " + estudanteDeletado.getName() + " deletado da base de dados.";
	}
	
}
