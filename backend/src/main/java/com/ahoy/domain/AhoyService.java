package com.ahoy.domain;

import com.ahoy.adapter.dtos.AgenteDTO;
import com.ahoy.adapter.dtos.RegiaoConsolidadaDTO;
import com.ahoy.adapter.dtos.RetornoProcessamento;
import com.ahoy.adapter.database.entity.AgenteEntity;
import com.ahoy.port.database.PortDatabaseSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AhoyService implements AhoyServiceSpec {
    private final PortDatabaseSpec portDatabaseSpec;

    @Autowired
    public AhoyService(final PortDatabaseSpec portDatabaseSpec) {
        this.portDatabaseSpec = portDatabaseSpec;
    }

    @Override
    public void saveAgentes(final List<AgenteDTO> agentes) {
        final List<AgenteEntity> agenteEntities = AgenteEntity.getInstance(agentes);
        portDatabaseSpec.saveAgentes(agenteEntities);

    }

    @Override
    public RetornoProcessamento<List<RegiaoConsolidadaDTO>> findConsolidatedByRegiao(final String siglaRegiao) {

        return portDatabaseSpec.getRegioesBySigla(siglaRegiao);
    }

    @Override
    public RetornoProcessamento<List<RegiaoConsolidadaDTO>> getConsolidatedByRegiao() {
        return portDatabaseSpec.getConsolidatedByRegiao();
    }
}
