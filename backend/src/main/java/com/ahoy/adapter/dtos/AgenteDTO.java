package com.ahoy.adapter.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgenteDTO {
    private String codigo;
    private String data;

    private List<RegiaoDTO> regioes;

}