package com.example.cadastro_pessoas.servicer;

    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro_pessoas.model.ProdutosModel;
import com.example.cadastro_pessoas.repository.ProdutosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    public ProdutosModel adicionarProduto(ProdutosModel produto) {
        return produtosRepository.save(produto);
    }

    public List<ProdutosModel> listarTodos() {
        return produtosRepository.findAll();
    }

    public Optional<ProdutosModel> buscarPorId(Long id) {
        return produtosRepository.findById(id);
    }

    public ProdutosModel atualizarProduto(Long id, ProdutosModel produtoAtualizado) {
        ProdutosModel produto = produtosRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setQuantidadeEstoque(produtoAtualizado.getQuantidadeEstoque());
        produto.setDescricao(produtoAtualizado.getDescricao());
        return produtosRepository.save(produto);
    }

    public void removerProduto(Long id) {
        produtosRepository.deleteById(id);
    }
}