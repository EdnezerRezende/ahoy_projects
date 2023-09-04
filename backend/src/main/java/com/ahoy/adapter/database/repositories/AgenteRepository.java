package com.ahoy.adapter.database.repositories;

import com.ahoy.adapter.database.entity.AgenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AgenteRepository extends JpaRepository<AgenteEntity, Long> {

}
