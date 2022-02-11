package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.Shift;
import com.ca.scheduler.core.domain.values.ShiftStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShiftRepository extends JpaRepository<Shift, Long>
{
    Optional<List<Shift>> findByShiftNoAndAttendantIdAndTerminalAndStatus(String shiftNo, String attendantId, String terminal, ShiftStatus status);
}