package com.ahoy.adapter;

import com.ahoy.adapter.dtos.RegiaoConsolidadaDTO;
import com.ahoy.adapter.dtos.RetornoProcessamento;
import com.ahoy.port.PortInboundSpec;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regiao")
public class RegiaoInboundAdapter {

    private final PortInboundSpec portInboundSpec;

    @Autowired
    public RegiaoInboundAdapter(final PortInboundSpec portInboundSpec) {

        this.portInboundSpec = portInboundSpec;
    }

    @GetMapping("/consolidated/{siglaRegiao}")
    @ApiResponse(description = "Send records consolidated by região ")
    public ResponseEntity<RetornoProcessamento<List<RegiaoConsolidadaDTO>>> getRecordsConsolidatedBySiglaRegiao(@PathVariable String siglaRegiao) {

        return ResponseEntity.ok(portInboundSpec.getRegioesBySigla(siglaRegiao));
    }

    @GetMapping("/consolidated")
    @ApiResponse(description = "Send records consolidated by região ")
    public ResponseEntity<RetornoProcessamento<List<RegiaoConsolidadaDTO>>> getRecordsConsolidatedByRegiao() {

        return ResponseEntity.ok(portInboundSpec.getConsolidatedByRegiao());
    }
}
