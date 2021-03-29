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

import com.myAPI.domain.Professor;
import com.myAPI.repo.ProfessorRepository;

@RestController
@RequestMapping("/professores")
public class ProfessorResource {
	
	@Autowired
	private ProfessorRepository professorRepo;
	
	@GetMapping()
	public List<Professor> listProfessores() {
		return professorRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Professor getProfessor(@PathVariable Long id) {
		return professorRepo.findById(id).orElse(null);
	}
	
	@PostMapping
	public Professor postProfessor(@RequestBody Professor professor) {
		Professor professorCadastrado = professorRepo.save(professor);
		return professorRepo.save(professorCadastrado);
	}
	
	@PutMapping("/{id}")
	public Professor atualizarEstudante(@PathVariable("id") Long id,
			@RequestBody Professor professor) {
		return professorRepo.findById(id).map(
				record -> {
					record.setAge(professor.getAge());
					record.setCurso(professor.getCurso());
					record.setName(professor.getName());
					return professorRepo.save(record);
				}).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProfessor(@PathVariable Long id) {
		Professor professorDeletado = professorRepo.findById(id).get();
		professorRepo.deleteById(id);
		return "Professor " + professorDeletado.getName() + " deletado da base de dados.";
	}
	

}
