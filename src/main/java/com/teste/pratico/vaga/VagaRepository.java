package com.teste.pratico.vaga;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

interface VagaRepository extends JpaRepository<Vaga, Long> {

    List<Vaga> findByInicioLessThanEqualAndFimGreaterThanEqual(LocalDate data, LocalDate data1);
}
