package com.ahoy.domain.entity;

import com.ahoy.adapter.dtos.RegiaoDTO;
import com.ahoy.domain.entity.children.CompraEntity;
import com.ahoy.domain.entity.children.GeracaoEntity;
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
    @JoinColumn(name = "agente_id")
    private AgenteEntity agente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CompraEntity> compra;

    @OneToMany(cascade = CascadeType.ALL)
    private List<GeracaoEntity> geracao;

    public static List<RegiaoEntity> getInstance(final List<RegiaoDTO> regioes) {

        final List<RegiaoEntity> regioesEntities = new ArrayList<>();

        regioes.forEach(regiaoDTO -> regioesEntities.add(RegiaoEntity.builder()
                .sigla(regiaoDTO.getSigla())
                .compra(CompraEntity.getInstance(regiaoDTO.getCompra()))
                .geracao(GeracaoEntity.getInstance(regiaoDTO.getGeracao()))
                .build()));
        return regioesEntities;
    }
}
