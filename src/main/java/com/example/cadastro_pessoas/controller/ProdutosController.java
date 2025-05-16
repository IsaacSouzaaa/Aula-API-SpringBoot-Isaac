package com.example.cadastro_pessoas.controller;

    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cadastro_pessoas.model.ProdutosModel;
import com.example.cadastro_pessoas.servicer.ProdutosService;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService produtoService;

    @PostMapping
    public ResponseEntity<ProdutosModel> adicionar(@RequestBody ProdutosModel produto) {
        return ResponseEntity.ok(produtoService.adicionarProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutosModel>> listar() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosModel> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosModel> atualizar(@PathVariable Long id, @RequestBody ProdutosModel produto) {
        return ResponseEntity.ok(produtoService.atualizarProduto(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        produtoService.removerProduto(id);
        return ResponseEntity.noContent().build();
    }
}