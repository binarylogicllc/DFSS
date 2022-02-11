/**
 * 
 */
package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Pugazhendhi
 *
 */
public interface QRCodeRepository extends JpaRepository<QrCode,Long> {

    Optional<QrCode> findByQrRef(String qrRef);
}
