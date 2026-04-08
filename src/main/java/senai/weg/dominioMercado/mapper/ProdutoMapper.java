package senai.weg.dominioMercado.mapper;

import org.springframework.stereotype.Component;
import senai.weg.dominioMercado.dto.produto.ProdutoRequest;
import senai.weg.dominioMercado.dto.produto.ProdutoResponse;
import senai.weg.dominioMercado.model.Produto;
@Component
public class ProdutoMapper {


    public Produto toEntity(ProdutoRequest produtoRequest) {
        return new Produto(produtoRequest.nome(), produtoRequest.estoque());
    }

    public ProdutoResponse toDTO(Produto produto){
        return new ProdutoResponse(produto.getId(),produto.getNome(),produto.getEstoque(),produto.getCategoria().getId());
    }


}
