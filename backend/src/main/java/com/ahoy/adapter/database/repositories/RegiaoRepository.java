package com.ahoy.adapter.database.repositories;

import com.ahoy.adapter.dtos.RegiaoConsolidadaDTO;
import com.ahoy.domain.entity.RegiaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegiaoRepository extends JpaRepository<RegiaoEntity, Long> {
    @Query("SELECT new com.ahoy.adapter.dtos.RegiaoConsolidadaDTO(r.sigla, SUM(c.valor), SUM(g.valor)) FROM Regiao r JOIN r.compra c JOIN r.geracao g GROUP BY r.sigla")
    List<RegiaoConsolidadaDTO> obterDadosConsolidadosPorRegiao();

    @Query("SELECT NEW com.ahoy.adapter.dtos.RegiaoConsolidadaDTO(r.sigla, SUM(c.valor), SUM(g.valor)) FROM Regiao r JOIN r.compra c JOIN r.geracao g WHERE r.sigla = :sigla GROUP BY r.sigla")
    List<RegiaoConsolidadaDTO> findConsolidatedRegiaoBySigla(String sigla);
}
