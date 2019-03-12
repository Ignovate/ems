
package com.ignovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ignovate.domain.EmployeeDetailEntity;

public interface EmployeeDetailRepo extends JpaRepository<EmployeeDetailEntity, Long>, JpaSpecificationExecutor<EmployeeDetailEntity>{

}
