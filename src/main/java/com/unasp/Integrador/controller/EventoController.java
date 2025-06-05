package com.unasp.Integrador.controller;

import com.unasp.Integrador.model.Evento;
import com.unasp.Integrador.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @PostMapping
    public ResponseEntity<Evento> criar(@RequestBody @Valid Evento evento) {
        Evento salvo = service.salvar(evento);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public List<Evento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizar(@PathVariable Long id, @RequestBody @Valid Evento evento) {
        Evento atualizado = service.atualizar(id, evento);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
