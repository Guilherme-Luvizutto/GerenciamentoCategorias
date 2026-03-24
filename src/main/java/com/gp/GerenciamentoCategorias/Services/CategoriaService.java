package com.gp.GerenciamentoCategorias.Services;

import com.gp.GerenciamentoCategorias.Models.CategoriaModel;
import com.gp.GerenciamentoCategorias.Repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaModel salvarCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<CategoriaModel> findAll() {
        return categoriaRepository.findAll();
    }

    public CategoriaModel findById(Long id) {
        return categoriaRepository.findById(id).get();
    }

    public void  deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
