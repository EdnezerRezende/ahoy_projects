package com.ahoy.port.database;

import com.ahoy.adapter.dtos.RegiaoConsolidadaDTO;
import com.ahoy.adapter.dtos.RetornoProcessamento;
import com.ahoy.domain.entity.AgenteEntity;

import java.util.List;


public interface PortDatabaseSpec {
    void saveAgentes(List<AgenteEntity> agentes);

    RetornoProcessamento<List<RegiaoConsolidadaDTO>> getRegioesBySigla(String siglaRegiao);
    RetornoProcessamento<List<RegiaoConsolidadaDTO>> getConsolidatedByRegiao();
}
