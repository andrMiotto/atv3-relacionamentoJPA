package senai.weg.dominioMercado.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ProdutoResponse> create(@RequestBody ProdutoRequest produtoRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.create(produtoRequest));

    }

    @GetMapping("/list")
    public ResponseEntity<List<ProdutoResponse>> listAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.listAll());

    }


    @GetMapping("/list/{id}")
    public ResponseEntity<ProdutoResponse> listId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.findById(id));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProdutoResponse> update(@PathVariable("id") long id, @RequestBody ProdutoRequest produtoRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.update(id, produtoRequest));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        produtoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
