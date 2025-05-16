package com.example.cadastro_pessoas.repository;

    import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cadastro_pessoas.model.ProdutosModel;

public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long> {
}