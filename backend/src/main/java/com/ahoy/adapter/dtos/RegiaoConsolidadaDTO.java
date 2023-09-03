package com.ahoy.adapter.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegiaoConsolidadaDTO {
    private String siglaRegiao;
    private Double totalCompra;
    private Double totalGeracao;
}
