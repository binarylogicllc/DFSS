package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Long>
{
    Optional<Station> findByMerchantIdAndStationId(String merchantId, String stationId);

    Optional<List<Station>> findByMerchantId(String merchantId);
}