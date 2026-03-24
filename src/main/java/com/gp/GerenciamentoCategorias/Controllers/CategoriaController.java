package com.gp.GerenciamentoCategorias.Controllers;

import com.gp.GerenciamentoCategorias.Models.CategoriaModel;
import com.gp.GerenciamentoCategorias.Repositories.CategoriaRepository;
import com.gp.GerenciamentoCategorias.Services.CategoriaService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Resource
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaModel> salvarCategoria(@RequestBody CategoriaModel categoriaModel) {
        CategoriaModel request = categoriaService.salvarCategoria(categoriaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(categoriaModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> findAll() {
        List<CategoriaModel> request = categoriaService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> findById(@PathVariable Long id) {
        CategoriaModel request = categoriaService.findById(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
