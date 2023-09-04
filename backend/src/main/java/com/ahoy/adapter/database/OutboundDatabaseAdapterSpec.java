package com.ahoy.adapter.database;

import com.ahoy.adapter.dtos.RegiaoConsolidadaDTO;
import com.ahoy.adapter.dtos.RetornoProcessamento;
import com.ahoy.adapter.database.entity.AgenteEntity;

import java.util.List;

public interface OutboundDatabaseAdapterSpec {
    void saveAgentes(List<AgenteEntity> agentes);

    RetornoProcessamento<List<RegiaoConsolidadaDTO>> getRegioesBySigla(String siglaRegiao);

    RetornoProcessamento<List<RegiaoConsolidadaDTO>> getConsolidatedByRegiao();
}
