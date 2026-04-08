package senai.weg.dominioMercado.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.weg.dominioMercado.dto.categoria.CategoriaRequest;
import senai.weg.dominioMercado.dto.categoria.CategoriaResponse;
import senai.weg.dominioMercado.mapper.CategoriaMapper;
import senai.weg.dominioMercado.model.Categoria;
import senai.weg.dominioMercado.repository.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {


    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;


    public CategoriaResponse create(CategoriaRequest categoriaRequest) {

        Categoria categoria = categoriaMapper.toEntity(categoriaRequest);

        Categoria categoria1 = categoriaRepository.save(categoria);


        CategoriaResponse categoriaResponse = categoriaMapper.toDTO(categoria);

        return categoriaResponse;
    }

    public List<CategoriaResponse> listAll() {

        if (categoriaRepository.findAll().isEmpty()) {
            throw new RuntimeException("Nao existe nenhuma categoria cadastrada");
        } else {
            List<Categoria> categorias = categoriaRepository.findAll();
            List<CategoriaResponse> dtos = new ArrayList<>();


            for (Categoria categoria : categorias) {
                dtos.add(categoriaMapper.toDTO(categoria));
            }
            return dtos;

        }

    }

    public CategoriaResponse findById(Long id) {
        if (categoriaRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Nao existe nenhuma categoria com esse id");
        } else {
            Categoria categoria = categoriaRepository.findById(id).orElseThrow();
            CategoriaResponse categoriaResponse = categoriaMapper.toDTO(categoria);

            return categoriaResponse;
        }

    }

    public CategoriaResponse update(Long id, CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não existe nenhuma categoria com este id"));
        categoria.setNome(categoriaRequest.nome());


        Categoria categoriaSalva = categoriaRepository.save(categoria);


        return categoriaMapper.toDTO(categoriaSalva);


    }

    public void delete(Long id) {

        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);

        } else {
            throw new RuntimeException("Esta categoria não existe");
        }

    }

}
