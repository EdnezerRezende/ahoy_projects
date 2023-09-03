package com.ahoy.domain.entity.children;

import com.ahoy.adapter.dtos.children.GeracaoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name = "Geracao")
public class GeracaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    public static List<GeracaoEntity> getInstance(final List<GeracaoDTO> geracao) {
        final List<GeracaoEntity> geracaoEntities = new ArrayList<>();
        geracao.forEach(geracaoDTO -> geracaoEntities.add(GeracaoEntity.builder()
                .valor(geracaoDTO.getValor())
                .build()));
        return geracaoEntities;
    }
}
