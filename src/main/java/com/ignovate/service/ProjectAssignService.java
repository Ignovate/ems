package com.ignovate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ignovate.repository.ProjectAssignRepo;
import com.ignovate.domain.ProjectAssignEntity;

@Service
public class ProjectAssignService {
	@Autowired
	private ProjectAssignRepo projectAssignRepo;
	
	public ProjectAssignEntity addProjectAssign(ProjectAssignEntity projAssignment) {
		return projectAssignRepo.save(projAssignment);
	}

	public List<ProjectAssignEntity> getAssignedProjects() {
		return projectAssignRepo.findAll();
	}

	public ProjectAssignEntity getAssignedProject(Long id) {
		return projectAssignRepo.findById(id).orElse(null);
	}

	public List<ProjectAssignEntity> getAssignedProjectsFilter(Map<String, String> params) {
		Specification<ProjectAssignEntity> specification = new Specification<ProjectAssignEntity>() {
			@Override
			public Predicate toPredicate(Root<ProjectAssignEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				params.forEach((k, v) -> predicates.add(cb.equal(root.get(k), v)));

				return cb.and(predicates.toArray(new Predicate[] {}));
			}
		};

		return projectAssignRepo.findAll(specification);
	}

}


