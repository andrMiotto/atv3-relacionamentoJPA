package senai.weg.dominioMercado.controller;

import lombok.RequiredArgsConstructor;
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
    public CategoriaResponse create(@RequestBody CategoriaRequest categoriaRequest) {
        return categoriaService.create(categoriaRequest);

    }

    @GetMapping("/list")
    public List<CategoriaResponse> listAll() {
        return categoriaService.listAll();

    }


    @GetMapping("/list/{id}")
    public CategoriaResponse listId(@PathVariable("id") Long id) {
        return categoriaService.findById(id);

    }

    @PutMapping("/update/{id}")
    public CategoriaResponse update(@PathVariable("id") long id, @RequestBody CategoriaRequest categoriaRequest) {
        return categoriaService.update(id, categoriaRequest);

    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        categoriaService.delete(id);
    }



}
