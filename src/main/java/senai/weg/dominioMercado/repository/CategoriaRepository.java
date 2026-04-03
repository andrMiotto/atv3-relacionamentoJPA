package senai.weg.dominioMercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senai.weg.dominioMercado.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
