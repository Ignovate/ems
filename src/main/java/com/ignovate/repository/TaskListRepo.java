/**
 * 
 */
package com.ignovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ignovate.domain.TaskListEntity;

/**
 * @author Suryanand
 *
 */
public interface TaskListRepo extends JpaRepository<TaskListEntity, Long>, JpaSpecificationExecutor<TaskListEntity>{

}
