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

import com.ignovate.repository.ProjectDetailRepo;
import com.ignovate.domain.ProjectDetailEntity;

@Service
public class ProjectDetailService {
	@Autowired
	private ProjectDetailRepo projectDetailRepo;
	
	public ProjectDetailEntity addProjectDetail(ProjectDetailEntity projectDetails) {
		return projectDetailRepo.save(projectDetails);
	}

	public List<ProjectDetailEntity> getProjectDetails() {
		return projectDetailRepo.findAll();
	}

	public ProjectDetailEntity getProjectDetail(Long id) {
		return projectDetailRepo.findById(id).orElse(null);
	}

	public List<ProjectDetailEntity> getProjectDetailFilter(Map<String, String> params) {
		Specification<ProjectDetailEntity> specification = new Specification<ProjectDetailEntity>() {
			@Override
			public Predicate toPredicate(Root<ProjectDetailEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				params.forEach((k, v) -> predicates.add(cb.equal(root.get(k), v)));

				return cb.and(predicates.toArray(new Predicate[] {}));
			}
		};

		return projectDetailRepo.findAll(specification);
	}

}


