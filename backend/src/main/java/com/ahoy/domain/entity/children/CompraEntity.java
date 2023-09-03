package com.ahoy.domain.entity.children;

import com.ahoy.adapter.dtos.children.CompraDTO;
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
@Entity(name = "Compra")
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    public static List<CompraEntity> getInstance(final List<CompraDTO> comprasDTO) {
        final List<CompraEntity> compraEntities = new ArrayList<>();
        comprasDTO.forEach(compraDTO -> compraEntities.add(CompraEntity.builder()
                .valor(compraDTO.getValor())
                .build()));
        return compraEntities;
    }

}
