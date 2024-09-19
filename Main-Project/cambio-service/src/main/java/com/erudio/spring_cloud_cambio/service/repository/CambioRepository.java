package com.erudio.spring_cloud_cambio.service.repository;

import com.erudio.spring_cloud_cambio.service.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<Cambio,Long> {

    Cambio findByFromAndTo (String from, String to);
}
