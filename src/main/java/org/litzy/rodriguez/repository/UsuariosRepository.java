package org.litzy.rodriguez.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.litzy.rodriguez.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
