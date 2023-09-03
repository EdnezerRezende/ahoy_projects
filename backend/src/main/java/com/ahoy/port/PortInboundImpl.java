package com.ahoy.port;

import com.ahoy.adapter.dtos.AgenteDTO;
import com.ahoy.adapter.dtos.RegiaoConsolidadaDTO;
import com.ahoy.adapter.dtos.RetornoProcessamento;
import com.ahoy.domain.AhoyServiceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PortInboundImpl implements PortInboundSpec {
    private final AhoyServiceSpec ahoyServiceSpec;

    @Autowired
    public PortInboundImpl(final AhoyServiceSpec ahoyServiceSpec) {
        this.ahoyServiceSpec = ahoyServiceSpec;
    }

    @Override
    public void saveAgentes(final List<AgenteDTO> agentes) {
        ahoyServiceSpec.saveAgentes(agentes);
    }

    @Override
    public RetornoProcessamento<List<RegiaoConsolidadaDTO>> getRegioesBySigla(final String siglaRegiao) {
        return ahoyServiceSpec.findConsolidatedByRegiao(siglaRegiao);
    }

    @Override
    public RetornoProcessamento<List<RegiaoConsolidadaDTO>> getConsolidatedByRegiao() {
        return ahoyServiceSpec.getConsolidatedByRegiao();
    }

}
