
package com.ignovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ignovate.domain.LeavemanagementEntity;

public interface LeaveDetailRepo extends JpaRepository<LeavemanagementEntity, Long>, JpaSpecificationExecutor<LeavemanagementEntity>{

}
