package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.TerminalForceUpdateScheduler;
import com.ca.scheduler.core.domain.TerminalWhitelist;
import com.ca.scheduler.core.domain.values.ForceUpdateSchedulerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TerminalForceUpdateSchedulerRepository extends JpaRepository<TerminalForceUpdateScheduler,String> {

    Optional<List<TerminalForceUpdateScheduler>> findByScheduledAtLessThanAndStatus(LocalDateTime scheduledAt, ForceUpdateSchedulerStatus forceUpdateSchedulerStatus);
}
