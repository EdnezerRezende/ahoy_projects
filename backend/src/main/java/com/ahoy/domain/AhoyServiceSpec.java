package com.ahoy.domain;

import com.ahoy.adapter.dtos.AgenteDTO;
import com.ahoy.adapter.dtos.RegiaoConsolidadaDTO;
import com.ahoy.adapter.dtos.RetornoProcessamento;

import java.util.List;

public interface AhoyServiceSpec {

    void saveAgentes(List<AgenteDTO> agentes);

    RetornoProcessamento<List<RegiaoConsolidadaDTO>> findConsolidatedByRegiao(String siglaRegiao);

    RetornoProcessamento<List<RegiaoConsolidadaDTO>> getConsolidatedByRegiao();
}
