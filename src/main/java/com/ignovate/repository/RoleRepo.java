/**
 * 
 */
package com.ignovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ignovate.domain.RoleEntity;



/**
 * @author Suryanand
 *
 */
public interface RoleRepo extends JpaRepository<RoleEntity, Long>, JpaSpecificationExecutor<RoleEntity>{

}
