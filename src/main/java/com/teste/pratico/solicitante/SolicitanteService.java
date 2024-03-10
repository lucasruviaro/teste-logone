package com.teste.pratico.solicitante;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitanteService {

    private final SolicitanteRepository repository;

    SolicitanteService(SolicitanteRepository repository) {
        this.repository = repository;
    }

    public List<Solicitante> buscarTodos(){
        return repository.findAll();
    }

    public void salvarSolicitante(Solicitante solicitante){
        repository.save(solicitante);
    }

    public Optional<Solicitante> encontrarPorId(Long solicitanteId) {
        return repository.findById(solicitanteId);
    }
}
