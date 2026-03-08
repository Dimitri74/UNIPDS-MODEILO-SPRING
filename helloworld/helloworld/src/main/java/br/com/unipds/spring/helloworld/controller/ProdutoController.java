package br.com.unipds.spring.helloworld.controller;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import br.com.unipds.spring.helloworld.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProdutoController {

    private ArrayList<Produto> database;

    public ProdutoController() {
        database = new ArrayList<>() {
            {
                add(new Produto(1, "Computador", 1500.0));
                add(new Produto(2, "Mouse", 50.0));
                add(new Produto(3, "Teclado", 100.0));
                add(new Produto(4, "Monitor", 500.0));
                add(new Produto(5, "Impressora", 350.0));
            }
        };
    }

    @GetMapping("/produtos")
    public ArrayList<Produto> recuperarTodos() {
        return database;
    }

    @GetMapping("/produtos/sort")
    public ResponseEntity<List<Produto>> recuperarOrdenado(@RequestParam(name="order", required = false) String order) {
        if (order == null) {
            return ResponseEntity.ok(database);
        } else if (order.equals("asc")) {
            return ResponseEntity.ok(database.stream().sorted(Comparator.comparing(Produto::getPreco)).toList());
        } else if (order.equals("desc")) {
            return ResponseEntity.ok(database.stream().sorted(Comparator.comparing(Produto::getPreco).reversed()).toList());
        } else
            return ResponseEntity.status(400).build();
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> recuperarPeloId(@PathVariable int id) {
        Produto prod = database.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if (prod != null) {
            return ResponseEntity.ok(prod);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/produtos")
    public Produto adicionarProduto(@RequestBody Produto novo) {
        database.add(novo);
        return novo;
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> alterarDados(@PathVariable int id, @RequestBody Produto produto) {
        int posicao = IntStream.range(0, database.size()).filter(i -> database.get(i).getId() == id).findFirst()
                .orElse(-1);
        if (posicao >= 0) {
            database.set(posicao, produto);
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/produtos/{id}")
    public Produto apagarProduto(@PathVariable int id) {
        int posicao = IntStream.range(0, database.size()).filter(i -> database.get(i).getId() == id).findFirst()
                .orElse(-1);
        if (posicao >= 0) {
            Produto tmp = database.get(posicao);
            database.remove(posicao);
            return tmp;
        }
        return null;
    }
}