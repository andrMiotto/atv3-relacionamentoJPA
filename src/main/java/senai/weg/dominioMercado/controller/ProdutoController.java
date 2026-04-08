package senai.weg.dominioMercado.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import senai.weg.dominioMercado.dto.produto.ProdutoRequest;
import senai.weg.dominioMercado.dto.produto.ProdutoResponse;
import senai.weg.dominioMercado.service.ProdutoService;

import java.util.List;



@RequiredArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {


    private final ProdutoService produtoService;


    @PostMapping("/register")
    public ProdutoResponse create(@RequestBody ProdutoRequest produtoRequest) {
        return produtoService.create(produtoRequest);

    }

    @GetMapping("/list")
    public List<ProdutoResponse> listAll() {
        return produtoService.listAll();

    }


    @GetMapping("/list/{id}")
    public ProdutoResponse listId(@PathVariable("id") Long id) {
        return produtoService.findById(id);

    }

    @PutMapping("/update/{id}")
    public ProdutoResponse update(@PathVariable("id") long id, @RequestBody ProdutoRequest produtoRequest) {
        return produtoService.update(id, produtoRequest);

    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        produtoService.delete(id);
    }






}
