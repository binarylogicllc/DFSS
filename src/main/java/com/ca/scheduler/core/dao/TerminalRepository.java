package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TerminalRepository extends JpaRepository<Terminal, Long>
{
    Optional<Terminal> findByDeviceSerial(String deviceSerial);
    Optional<Terminal> findByTerminalId(String terminalId);
    Optional<List<Terminal>> findByStationId(String stationId);
    Optional<Terminal> findByTerminalIdAndDeviceSerial(String terminalId , String deviceSerial);
}