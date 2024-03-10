package com.teste.pratico.agendamento;

import com.teste.pratico.agendamento.exceptions.VagaNaoEncontradaException;
import com.teste.pratico.solicitante.Solicitante;
import com.teste.pratico.solicitante.SolicitanteService;
import com.teste.pratico.vaga.Vaga;
import com.teste.pratico.vaga.VagaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final VagaService vagaService;

    private final SolicitanteService solicitanteService;

    AgendamentoService(AgendamentoRepository repository, VagaService vagaService, SolicitanteService solicitanteService) {
        this.agendamentoRepository = repository;
        this.vagaService = vagaService;
        this.solicitanteService = solicitanteService;
    }

    @Transactional
    public void salvarAgendamento(Agendamento agendamento) throws VagaNaoEncontradaException {
        List<Vaga> vagasIntersectadas = buscaQuantidadedeVagasPorPeriodo(agendamento);
        boolean vagasDisponiveis = vagasIntersectadas.stream().anyMatch(vaga -> vaga.getQuantidade() > 0);

        if (vagasDisponiveis) {
            agendamentoRepository.save(agendamento);
            atualizaNumeroVagasAposAgendamento(vagasIntersectadas);
        } else {
            throw new VagaNaoEncontradaException("Não há vagas disponíveis para a data indicada.");
        }

    }

    private List<Vaga> buscaQuantidadedeVagasPorPeriodo(Agendamento agendamento) {
        return vagaService.buscaQuantidadeVagasPorPeriodo(agendamento.getData(), agendamento.getData());
    }

    public boolean verificaDisponibilidadeVagas(List<Vaga> vagasDisponiveis) {
        return !vagasDisponiveis.isEmpty();
    }

    private static void atualizaNumeroVagasAposAgendamento(List<Vaga> vagasDisponiveis) {
       vagasDisponiveis.stream()
            .filter(vaga -> vaga.getQuantidade() > 0)
            .findFirst()
            .ifPresent(vaga -> vaga.setQuantidade(vaga.getQuantidade() - 1););
    }

    public List<Agendamento> buscarAgendamentosPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {

        return agendamentoRepository.buscarAgendamentosPorPeriodo(dataInicio, dataFim).stream()
                .peek(agendamento -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    String dataFormatada = agendamento.getData().format(formatter);
                    agendamento.setData(LocalDate.parse(dataFormatada, formatter));
                })
                .toList();
    }

    public Optional<Solicitante> findById(Long solicitanteId) {
        return solicitanteService.encontrarPorId(solicitanteId);
    }

}
