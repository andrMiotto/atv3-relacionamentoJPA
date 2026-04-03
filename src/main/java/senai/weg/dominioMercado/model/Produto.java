package senai.weg.dominioMercado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
public class Produto {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String nome;


    @Column(nullable = false)
    int estoque;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    public Produto(String nome, int estoque) {
        this.nome = nome;
        this.estoque = estoque;
    }
}

