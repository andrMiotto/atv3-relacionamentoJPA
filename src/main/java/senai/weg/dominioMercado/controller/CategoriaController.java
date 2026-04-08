package senai.weg.dominioMercado.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.weg.dominioMercado.dto.categoria.CategoriaRequest;
import senai.weg.dominioMercado.dto.categoria.CategoriaResponse;
import senai.weg.dominioMercado.service.CategoriaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;


    @PostMapping("/register")
    public ResponseEntity<CategoriaResponse> create(@RequestBody CategoriaRequest categoriaRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoriaService.create(categoriaRequest));

    }

    @GetMapping("/list")
    public ResponseEntity<List<CategoriaResponse>> listAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoriaService.listAll());

    }


    @GetMapping("/list/{id}")
    public ResponseEntity<CategoriaResponse> listId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoriaService.findById(id));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoriaResponse> update(@PathVariable("id") long id, @RequestBody CategoriaRequest categoriaRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoriaService.update(id, categoriaRequest));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        categoriaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
