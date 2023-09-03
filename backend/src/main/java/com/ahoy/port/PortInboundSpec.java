package com.ahoy.port;

import com.ahoy.adapter.dtos.AgenteDTO;
import com.ahoy.adapter.dtos.RegiaoConsolidadaDTO;
import com.ahoy.adapter.dtos.RetornoProcessamento;

import java.util.List;

public interface PortInboundSpec {
    void saveAgentes(List<AgenteDTO> agentes);

    RetornoProcessamento<List<RegiaoConsolidadaDTO>> getRegioesBySigla(String siglaRegiao);
    RetornoProcessamento<List<RegiaoConsolidadaDTO>> getConsolidatedByRegiao();
}
