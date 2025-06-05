package com.unasp.Integrador.service;

import com.unasp.Integrador.model.Evento;
import com.unasp.Integrador.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public Evento salvar(Evento evento) {
        return repository.save(evento);
    }

    public List<Evento> listar() {
        return repository.findAll();
    }

    public Evento atualizar(Long id, Evento novoEvento) {
        Evento existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        existente.setNome(novoEvento.getNome());
        existente.setData(novoEvento.getData());
        existente.setDescricao(novoEvento.getDescricao());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Evento buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
    }
}
