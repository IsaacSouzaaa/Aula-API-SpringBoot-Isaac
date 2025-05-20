package com.example.cadastro_pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro_pessoas.model.Compra;
import com.example.cadastro_pessoas.servicer.CompraService;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> registrarCompra(@RequestBody Compra compra) {
        return ResponseEntity.ok(compraService.registrarCompra(compra));
    }

    @GetMapping
    public ResponseEntity<List<Compra>> listarCompras() {
        return ResponseEntity.ok(compraService.listarCompras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(compraService.buscarCompraPorId(id));
    }

    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<Compra>> listarPorPessoa(@PathVariable Long idPessoa) {
        return ResponseEntity.ok(compraService.listarComprasPorPessoa(idPessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarCompra(@PathVariable Long id) {
        compraService.cancelarCompra(id);
        return ResponseEntity.noContent().build();
    }
}
