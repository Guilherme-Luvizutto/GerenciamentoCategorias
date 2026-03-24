package com.gp.GerenciamentoCategorias.Repositories;

import com.gp.GerenciamentoCategorias.Models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}
