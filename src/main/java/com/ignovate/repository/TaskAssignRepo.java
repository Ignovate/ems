/**
 * 
 */
package com.ignovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ignovate.domain.TaskAssignEntity;

/**
 * @author Suryanand
 *
 */
public interface TaskAssignRepo extends JpaRepository<TaskAssignEntity, Long>, JpaSpecificationExecutor<TaskAssignEntity>{
	
}
