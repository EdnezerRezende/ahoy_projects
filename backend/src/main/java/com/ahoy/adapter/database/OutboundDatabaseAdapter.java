package com.ahoy.adapter.database;

import com.ahoy.adapter.database.repositories.AgenteRepository;
import com.ahoy.adapter.database.repositories.RegiaoRepository;
import com.ahoy.adapter.dtos.RegiaoConsolidadaDTO;
import com.ahoy.adapter.dtos.RetornoProcessamento;
import com.ahoy.domain.entity.AgenteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class OutboundDatabaseAdapter implements OutboundDatabaseAdapterSpec {

    private final AgenteRepository agenteRepository;
    private final RegiaoRepository regiaoRepository;

    @Autowired
    public OutboundDatabaseAdapter(final AgenteRepository agenteRepository,
                                   final RegiaoRepository regiaoRepository) {
        this.agenteRepository = agenteRepository;
        this.regiaoRepository = regiaoRepository;
    }

    @Override
    @Transactional
    public void saveAgentes(final List<AgenteEntity> agentes) {
        agenteRepository.saveAll(agentes);
        agentes.forEach(System.out::println);
    }

    @Override
    public RetornoProcessamento<List<RegiaoConsolidadaDTO>> getRegioesBySigla(final String siglaRegiao) {
        final List<RegiaoConsolidadaDTO> consolidatedRegiaoBySigla = regiaoRepository.findConsolidatedRegiaoBySigla(siglaRegiao);
        return RetornoProcessamento.<List<RegiaoConsolidadaDTO>>builder().data(consolidatedRegiaoBySigla).build();
    }

    @Override
    public RetornoProcessamento<List<RegiaoConsolidadaDTO>> getConsolidatedByRegiao() {
        final List<RegiaoConsolidadaDTO> regiaoConsolidadaDTOS = regiaoRepository.obterDadosConsolidadosPorRegiao();
        return RetornoProcessamento.<List<RegiaoConsolidadaDTO>>builder().data(regiaoConsolidadaDTOS).build();
    }
}
