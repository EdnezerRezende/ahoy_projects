package com.ahoy.domain.entity;

import com.ahoy.adapter.dtos.AgenteDTO;
import com.ahoy.domain.converters.DateConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(of = {"codigo"})
@Entity(name = "Agente")
public class AgenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private LocalDate data;

    @OneToMany(mappedBy = "agente", cascade = CascadeType.ALL)
    private List<RegiaoEntity> regioes;

    public static List<AgenteEntity> getInstance(final List<AgenteDTO> agentes){
        final List<AgenteEntity> agentesEntity = new ArrayList<>();
        agentes.forEach(agenteDTO -> agentesEntity.add(AgenteEntity.builder()
                .codigo(agenteDTO.getCodigo())
                .data(DateConverter.convertStringToLocalDate(agenteDTO.getData()))
                .regioes(RegiaoEntity.getInstance(agenteDTO.getRegioes()))
                .build()));
        return agentesEntity;
    }

}