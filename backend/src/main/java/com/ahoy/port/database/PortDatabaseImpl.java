package com.ahoy.port.database;

import com.ahoy.adapter.database.OutboundDatabaseAdapterSpec;
import com.ahoy.adapter.dtos.RegiaoConsolidadaDTO;
import com.ahoy.adapter.dtos.RetornoProcessamento;
import com.ahoy.domain.entity.AgenteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PortDatabaseImpl implements PortDatabaseSpec {
    private final OutboundDatabaseAdapterSpec outboundDatabaseAdapterSpec;

    @Autowired
    public PortDatabaseImpl(final OutboundDatabaseAdapterSpec outboundDatabaseAdapterSpec) {
        this.outboundDatabaseAdapterSpec = outboundDatabaseAdapterSpec;
    }

    @Override
    public void saveAgentes(final List<AgenteEntity> agentes) {
        outboundDatabaseAdapterSpec.saveAgentes(agentes);
    }

    @Override
    public RetornoProcessamento<List<RegiaoConsolidadaDTO>> getRegioesBySigla(final String siglaRegiao) {
        return outboundDatabaseAdapterSpec.getRegioesBySigla(siglaRegiao);
    }

    @Override
    public RetornoProcessamento<List<RegiaoConsolidadaDTO>> getConsolidatedByRegiao() {
        return outboundDatabaseAdapterSpec.getConsolidatedByRegiao();
    }
}
