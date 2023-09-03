package com.ahoy.adapter.dtos;

import com.ahoy.adapter.dtos.children.CompraDTO;
import com.ahoy.adapter.dtos.children.GeracaoDTO;
import com.ahoy.adapter.dtos.children.PrecoMedioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegiaoDTO {
    private String sigla;

    private List<GeracaoDTO> geracao;

    private List<CompraDTO> compra;

    private List<PrecoMedioDTO> precoMedio;
}
