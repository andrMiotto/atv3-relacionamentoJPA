package senai.weg.dominioMercado.dto.produto;

import senai.weg.dominioMercado.dto.categoria.CategoriaResponse;
import senai.weg.dominioMercado.model.Produto;

import java.util.List;

public record ProdutoRequest(


        String nome,
        int estoque,
        Long categoriaId



) {
}
