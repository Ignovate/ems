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

import com.ignovate.repository.EmployeeDetailRepo;
import com.ignovate.domain.EmployeeDetailEntity;

@Service
public class EmployeeDetailService {
	@Autowired
	private EmployeeDetailRepo employeeDetailRepo;
	
	public EmployeeDetailEntity addEmployeeDetail(EmployeeDetailEntity log) {
		return employeeDetailRepo.save(log);
	}

	public List<EmployeeDetailEntity> getEmployeeDetails() {
		return employeeDetailRepo.findAll();
	}

	public EmployeeDetailEntity getEmployeeDetail(Long id) {
		return employeeDetailRepo.findById(id).orElse(null);
	}

	public List<EmployeeDetailEntity> getEmployeeDetailWithFilter(Map<String, String> params) {
		Specification<EmployeeDetailEntity> specification = new Specification<EmployeeDetailEntity>() {
			@Override
			public Predicate toPredicate(Root<EmployeeDetailEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				params.forEach((k, v) -> predicates.add(cb.equal(root.get(k), v)));

				return cb.and(predicates.toArray(new Predicate[] {}));
			}
		};

		return employeeDetailRepo.findAll(specification);
	}

}
