package com.dt2.gtavi.controller;

import com.dt2.gtavi.entities.Arma;
import com.dt2.gtavi.entities.Personagem;
import com.dt2.gtavi.repositories.ArmaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/armas")
public class ArmaController {

    private final ArmaRepository repository;

    public ArmaController(ArmaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String criarArma(@RequestBody Arma AK47) {
        try {
            repository.save(AK47);
            return "Salvo com sucesso!";
        } catch (Exception e) {
            return "Dados Incorretos!";
        }
    }

    @GetMapping
    public List<Arma> mostrar() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    public void buscarId(@PathVariable int id) {
        repository.findById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id, @RequestBody Arma a) {
        Arma arma = repository.getReferenceById(id);
        arma.setNome(a.getNome());
        arma.setFabricante(a.getFabricante());
        arma.setCategoria(a.getCategoria());
        arma.setImagem(a.getImagem());
        arma.setDescricao(a.getDescricao());
        repository.save(arma);
    }
}
