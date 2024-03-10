package com.teste.pratico.vaga;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VagaService {

    private final VagaRepository repository;

    VagaService(VagaRepository repository) {
        this.repository = repository;
    }

    public void salvarVaga(Vaga vaga) {
        repository.save(vaga);
    }

    public List<Vaga> buscaQuantidadeVagasPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        return repository.findByInicioLessThanEqualAndFimGreaterThanEqual(dataInicio, dataFim);
    }
}
