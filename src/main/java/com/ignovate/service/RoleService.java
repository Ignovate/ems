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

import com.ignovate.domain.RoleEntity;
import com.ignovate.repository.RoleRepo;

/**
 * @author Suryanand
 *
 */
@Service
public class RoleService {
	@Autowired
	private RoleRepo roleRepo;
	
	public RoleEntity addRole(RoleEntity log) {
		return roleRepo.save(log);
	}

	public List<RoleEntity> getRoleDetails() {
		return roleRepo.findAll();
	}

	public RoleEntity getRoleDetail(Long id) {
		return roleRepo.findById(id).orElse(null);
	}

	public List<RoleEntity> getRoleDetailWithFilter(Map<String, String> params) {
		Specification<RoleEntity> specification = new Specification<RoleEntity>() {
			@Override
			public Predicate toPredicate(Root<RoleEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				params.forEach((k, v) -> predicates.add(cb.equal(root.get(k), v)));

				return cb.and(predicates.toArray(new Predicate[] {}));
			}
		};

		return roleRepo.findAll(specification);
	}
}
