package com.ahoy.adapter;

import com.ahoy.adapter.dtos.AgentesDTO;
import com.ahoy.adapter.dtos.RetornoProcessamento;
import com.ahoy.port.PortInboundSpec;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agente")
public class AgenteInboundAdapter {

    private final PortInboundSpec portInboundSpec;

    @Autowired
    public AgenteInboundAdapter(final PortInboundSpec portInboundSpec) {
        this.portInboundSpec = portInboundSpec;
    }

    @PostMapping()
    @ApiResponse(description = "Received records agentes ")
    public ResponseEntity<RetornoProcessamento<String>> agentes(@RequestBody final AgentesDTO agentes) {

        portInboundSpec.saveAgentes(agentes.getAgentes());

        return ResponseEntity.ok(RetornoProcessamento.<String>builder().data("Processamento efetuado com sucesso.").build());

    }

}
