package com.ignovate.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ignovate.domain.AttendanceEntity;

public interface AttendanceDetailRepo extends JpaRepository<AttendanceEntity, Long>, JpaSpecificationExecutor<AttendanceEntity>{

}
