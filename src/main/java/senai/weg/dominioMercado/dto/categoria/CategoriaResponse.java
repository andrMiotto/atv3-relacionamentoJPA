package senai.weg.dominioMercado.dto.categoria;

import senai.weg.dominioMercado.model.Produto;

import java.util.List;

public record CategoriaResponse(


        long id,
        String nome,
        List<Produto> produtos

) {
}
