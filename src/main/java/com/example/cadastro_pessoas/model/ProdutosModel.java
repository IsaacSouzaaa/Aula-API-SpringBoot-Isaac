package com.example.cadastro_pessoas.model;

    import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class ProdutosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;

    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    private String descricao;

    public Object getNome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }

    public void setNome(Object nome2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNome'");
    }

    public Object getPreco() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPreco'");
    }

    public void setPreco(Object preco2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPreco'");
    }

    public Object getQuantidadeEstoque() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQuantidadeEstoque'");
    }

    public void setQuantidadeEstoque(Object quantidadeEstoque2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setQuantidadeEstoque'");
    }

    public Object getDescricao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescricao'");
    }

    public void setDescricao(Object descricao2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDescricao'");
    }

}