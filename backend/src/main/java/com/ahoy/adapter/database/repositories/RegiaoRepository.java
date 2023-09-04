package com.ahoy.adapter.database.repositories;

import com.ahoy.adapter.dtos.RegiaoConsolidadaDTO;
import com.ahoy.adapter.database.entity.RegiaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegiaoRepository extends JpaRepository<RegiaoEntity, Long> {
    @Query(value = "SELECT NEW com.ahoy.adapter.dtos.RegiaoConsolidadaDTO(r.sigla, r.compra, r.geracao) " +
            "FROM Regiao r " +
            "GROUP BY r.sigla, r.compra, r.geracao")
    List<RegiaoConsolidadaDTO> obterDadosConsolidadosPorRegiao();

    @Query("SELECT NEW com.ahoy.adapter.dtos.RegiaoConsolidadaDTO(r.sigla, SUM(r.compra), SUM(r.geracao)) FROM Regiao r WHERE r.sigla = :sigla GROUP BY r.sigla")
    List<RegiaoConsolidadaDTO> findConsolidatedRegiaoBySigla(String sigla);
}
