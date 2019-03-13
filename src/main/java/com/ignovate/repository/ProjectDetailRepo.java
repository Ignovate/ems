
package com.ignovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.ignovate.domain.ProjectDetailEntity;

public interface ProjectDetailRepo extends JpaRepository<ProjectDetailEntity, Long>, JpaSpecificationExecutor<ProjectDetailEntity>{

}
