package com.practica01.repository;

import com.practica01.domain.Suculenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Acceso a la tabla suculenta. JpaRepository ya incluye los metodos
 * del CRUD (findAll, save, existsById, deleteById), por eso queda vacio.
 */
@Repository
public interface SuculentaRepository extends JpaRepository<Suculenta, Integer> {
}
