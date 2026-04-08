package senai.weg.dominioMercado.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.weg.dominioMercado.dto.produto.ProdutoRequest;
import senai.weg.dominioMercado.dto.produto.ProdutoResponse;
import senai.weg.dominioMercado.mapper.ProdutoMapper;
import senai.weg.dominioMercado.model.Categoria;
import senai.weg.dominioMercado.model.Produto;
import senai.weg.dominioMercado.repository.CategoriaRepository;
import senai.weg.dominioMercado.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private  final ProdutoRepository produtoRepository;

    private  final ProdutoMapper produtoMapper;
    private final CategoriaRepository categoriaRepository;


    public ProdutoResponse create(ProdutoRequest produtoRequest) {

        Produto produto = produtoMapper.toEntity(produtoRequest);

        Categoria categoria = categoriaRepository.findById(produtoRequest.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com o ID: " + produtoRequest.categoriaId()));

        produto.setCategoria(categoria);

        Produto produtoSalvo = produtoRepository.save(produto);

        ProdutoResponse produtoResponse = produtoMapper.toDTO(produtoSalvo);

        return produtoResponse;
    }

    public List<ProdutoResponse> listAll() {

        if (produtoRepository.findAll().isEmpty()) {
            throw new RuntimeException("Nao existe nenhum produto cadastrado");
        } else {
            List<Produto> produtos = produtoRepository.findAll();
            List<ProdutoResponse> dtos = new ArrayList<>();


            for (Produto produto : produtos) {
                dtos.add(produtoMapper.toDTO(produto));
            }
            return dtos;

        }

    }

    public ProdutoResponse findById(Long id) {
        if (produtoRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Nao existe nenhum produto com esse id");
        } else {
            Produto produto = produtoRepository.findById(id).orElseThrow();
            ProdutoResponse produtoResponse = produtoMapper.toDTO(produto);

            return produtoResponse;
        }

    }

    public ProdutoResponse update(Long id, ProdutoRequest produtoRequest) {

        Optional<Categoria> categoria = categoriaRepository.findById(produtoRequest.categoriaId());
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não existe nenhum produto com este id"));
        produto.setNome(produtoRequest.nome());

        produto.setEstoque(produtoRequest.estoque());

        produto.setCategoria(categoria.get());

        Produto produtoSalvo = produtoRepository.save(produto);


        return produtoMapper.toDTO(produtoSalvo);


    }

    public void delete(Long id) {

        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);

        } else {
            throw new RuntimeException("Este produto não existe");
        }

    }

}
