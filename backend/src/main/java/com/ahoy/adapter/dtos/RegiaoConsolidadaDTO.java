package com.ahoy.adapter.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
public class RegiaoConsolidadaDTO {
    private String siglaRegiao;
    private Double totalCompra = 0.0;
    private Double totalGeracao = 0.0;

    public RegiaoConsolidadaDTO() {
    }

    public RegiaoConsolidadaDTO(final String sigla, final Double totalCompra, final Double totalGeracao) {
        this.siglaRegiao = sigla;
        this.totalCompra = totalCompra;
        this.totalGeracao = totalGeracao;
    }
    public RegiaoConsolidadaDTO(final String sigla, final List<Double> totalCompra, final List<Double> totalGeracao) {
        this.siglaRegiao = sigla;
        totalCompra.forEach(compra -> this.totalCompra = this.getTotalCompra() + compra);
        totalGeracao.forEach(geracao -> this.totalGeracao = this.getTotalGeracao() + geracao);
    }
}
