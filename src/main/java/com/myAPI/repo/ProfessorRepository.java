package com.myAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myAPI.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
