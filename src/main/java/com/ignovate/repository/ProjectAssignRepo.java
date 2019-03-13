
package com.ignovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.ignovate.domain.ProjectAssignEntity;

public interface ProjectAssignRepo extends JpaRepository<ProjectAssignEntity, Long>, JpaSpecificationExecutor<ProjectAssignEntity>{

}
