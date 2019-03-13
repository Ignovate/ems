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

import com.ignovate.domain.TaskListEntity;
import com.ignovate.repository.TaskListRepo;

/**
 * @author Suryanand
 *
 */
@Service
public class TaskListService {
	@Autowired
	private TaskListRepo taskListRepo;
	
	public TaskListEntity addTaskList(TaskListEntity log) {
		return taskListRepo.save(log);
	}

	public List<TaskListEntity> getTaskListDetails() {
		return taskListRepo.findAll();
	}

	public TaskListEntity getTaskListDetail(Long id) {
		return taskListRepo.findById(id).orElse(null);
	}

	public List<TaskListEntity> getTaskListWithFilter(Map<String, String> params) {
		Specification<TaskListEntity> specification = new Specification<TaskListEntity>() {
			@Override
			public Predicate toPredicate(Root<TaskListEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				params.forEach((k, v) -> predicates.add(cb.equal(root.get(k), v)));

				return cb.and(predicates.toArray(new Predicate[] {}));
			}
		};

		return taskListRepo.findAll(specification);
	}
}
