package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.TerminalParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TerminalParameterRepository extends JpaRepository<TerminalParameter, Long>
{
    Optional<List<TerminalParameter>> findByTerminalId(String terminalId);

    Optional<TerminalParameter> findByTerminalIdAndParamName(String terminalId, ParamName paramName);
}
