package senai.weg.dominioMercado.dto.produto;

import senai.weg.dominioMercado.dto.categoria.CategoriaResponse;

public record ProdutoResponse(

        Long id,
        String nome,
        int estoque,
        Long categoriaId



) {}


