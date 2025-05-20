package com.example.cadastro_pessoas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cadastro_pessoas.model.Compra;
import com.example.cadastro_pessoas.model.ItemCompra;

public interface ComprasRepository extends JpaRepository<Compra, Long> {
    List<Compra> findByPessoaId(Long pessoaId);
}