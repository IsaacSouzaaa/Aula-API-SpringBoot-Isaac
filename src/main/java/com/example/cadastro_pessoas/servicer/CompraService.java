package com.example.cadastro_pessoas.servicer;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro_pessoas.model.Compra;
import com.example.cadastro_pessoas.model.ItemCompra;
import com.example.cadastro_pessoas.model.ProdutosModel;
import com.example.cadastro_pessoas.repository.ComprasRepository;
import com.example.cadastro_pessoas.repository.ItemsCompraRepository;
import com.example.cadastro_pessoas.repository.ProdutosRepository;

    @Service
public class CompraService {

    @Autowired
    private ComprasRepository compraRepository;

    @Autowired
    private ItemsCompraRepository itemsCompraRepository;

    @Autowired
    private ProdutosRepository produtoRepository;

    public Compra registrarCompra(Compra compra) {
        compra.setDataCompra(LocalDateTime.now());

        for (ItemCompra item : compra.getItens()) {
            ProdutosModel produto = produtoRepository.findById((Long) item.getProduto()).orElseThrow();
            produto.setQuantidadeEstoque(item.getQuantidade());
            produtoRepository.save(produto);
            item.setPrecoUnitario(produto.getPreco());
            item.setCompra(compra);
        }

        return compraRepository.save(compra);
    }

    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    public Compra buscarCompraPorId(Long id) {
        return compraRepository.findById(id).orElseThrow();
    }

    public List<Compra> listarComprasPorPessoa(Long pessoaId) {
        return compraRepository.findByPessoaId(pessoaId);
    }

    public void cancelarCompra(Long id) {
        compraRepository.deleteById(id);
    }
}
