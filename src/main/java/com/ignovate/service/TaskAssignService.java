/**
 * 
 */
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

import com.ignovate.domain.TaskAssignEntity;
import com.ignovate.repository.TaskAssignRepo;

/**
 * @author Suryanand
 *
 */
@Service
public class TaskAssignService {
	@Autowired
	private TaskAssignRepo taskAssignRepo;
	
	public TaskAssignEntity addTaskAssign(TaskAssignEntity log) {
		return taskAssignRepo.save(log);
	}

	public List<TaskAssignEntity> getTaskAssignDetails() {
		return taskAssignRepo.findAll();
	}

	public TaskAssignEntity getTaskAssignDetail(Long id) {
		return taskAssignRepo.findById(id).orElse(null);
	}

	public List<TaskAssignEntity> getTaskAssignWithFilter(Map<String, String> params) {
		Specification<TaskAssignEntity> specification = new Specification<TaskAssignEntity>() {
			@Override
			public Predicate toPredicate(Root<TaskAssignEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				params.forEach((k, v) -> predicates.add(cb.equal(root.get(k), v)));

				return cb.and(predicates.toArray(new Predicate[] {}));
			}
		};

		return taskAssignRepo.findAll(specification);
	}
}
