package senai.weg.dominioMercado.mapper;


import org.springframework.stereotype.Component;
import senai.weg.dominioMercado.dto.categoria.CategoriaRequest;
import senai.weg.dominioMercado.dto.categoria.CategoriaResponse;
import senai.weg.dominioMercado.model.Categoria;
@Component
public class CategoriaMapper {


    public Categoria toEntity(CategoriaRequest categoriaRequest) {
        return new Categoria(categoriaRequest.nome());
    }

    public CategoriaResponse toDTO(Categoria categoria) {
        return new CategoriaResponse(categoria.getId(), categoria.getNome(), categoria.getProdutos());
    }


}
