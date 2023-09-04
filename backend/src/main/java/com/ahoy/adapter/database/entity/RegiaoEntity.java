package com.ahoy.adapter.database.entity;

import com.ahoy.adapter.dtos.RegiaoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Regiao")
public class RegiaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sigla;

    @ManyToOne
    @JsonIgnore
    private AgenteEntity agente;

    private List<Double> compra = new ArrayList<>();

    private List<Double> geracao = new ArrayList<>();

    public static List<RegiaoEntity> getInstance(final List<RegiaoDTO> regioes) {

        final List<RegiaoEntity> regioesEntities = new ArrayList<>();

        regioes.forEach(regiaoDTO -> regioesEntities.add(RegiaoEntity.builder()
                .sigla(regiaoDTO.getSigla())
                .compra(regiaoDTO.getCompra())
                .geracao(regiaoDTO.getGeracao())
                .build()));
        return regioesEntities;
    }
}
