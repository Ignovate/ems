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

import com.ignovate.repository.AttendanceDetailRepo;

import com.ignovate.domain.AttendanceEntity;


@Service
public class AttendanceDetailService {
	@Autowired
	private AttendanceDetailRepo attendanceDetailRepo;
	
	public AttendanceEntity addAttendanceDetail(AttendanceEntity log) {
		return attendanceDetailRepo.save(log);
	}

	public List<AttendanceEntity> getAttendanceDetails() {
		return attendanceDetailRepo.findAll();
	}

	public AttendanceEntity getAttendanceDetail(Long id) {
		return attendanceDetailRepo.findById(id).orElse(null);
	}

	public List<AttendanceEntity> getAttendanceDetailWithFilter(Map<String, String> params) {
		Specification<AttendanceEntity> specification = new Specification<AttendanceEntity>() {
			@Override
			public Predicate toPredicate(Root<AttendanceEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				params.forEach((k, v) -> predicates.add(cb.equal(root.get(k), v)));

				return cb.and(predicates.toArray(new Predicate[] {}));
			}
		};

		return attendanceDetailRepo.findAll(specification);
	}

}
