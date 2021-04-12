package org.litzy.rodriguez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.litzy.rodriguez.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {
	
	public List<Vacante> findByEstatus(String estatus);
	public List<Vacante> findByEstatusAndDestacado(String estatus, Integer destacado);

}
