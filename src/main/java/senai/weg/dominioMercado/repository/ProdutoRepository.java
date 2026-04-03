package senai.weg.dominioMercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senai.weg.dominioMercado.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
