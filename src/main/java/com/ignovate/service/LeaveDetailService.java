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

import com.ignovate.repository.LeaveDetailRepo;

import com.ignovate.domain.LeavemanagementEntity;


@Service
public class LeaveDetailService {
	@Autowired
	private LeaveDetailRepo leaveDetailRepo;
	
	public LeavemanagementEntity addLeaveDetail(LeavemanagementEntity log) {
		return leaveDetailRepo.save(log);
	}

	public List<LeavemanagementEntity> getLeaveDetails() {
		return leaveDetailRepo.findAll();
	}

	public LeavemanagementEntity getLeaveDetail(Long id) {
		return leaveDetailRepo.findById(id).orElse(null);
	}

	public List<LeavemanagementEntity> getLeaveDetailWithFilter(Map<String, String> params) {
		Specification<LeavemanagementEntity> specification = new Specification<LeavemanagementEntity>() {
			@Override
			public Predicate toPredicate(Root<LeavemanagementEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				params.forEach((k, v) -> predicates.add(cb.equal(root.get(k), v)));

				return cb.and(predicates.toArray(new Predicate[] {}));
			}
		};

		return leaveDetailRepo.findAll(specification);
	}

}
