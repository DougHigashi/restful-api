package com.myAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myAPI.domain.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
