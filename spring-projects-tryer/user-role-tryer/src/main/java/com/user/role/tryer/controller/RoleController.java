package com.user.role.tryer.controller;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.role.tryer.entity.wrapper.FunctionWrapper;
import com.user.role.tryer.entity.wrapper.RoleScopeWrapper;
import com.user.role.tryer.entity.wrapper.RoleWrapper;
import com.user.role.tryer.entity.wrapper.ScopeWrapper;
import com.user.role.tryer.model.RoleObject;
import com.user.role.tryer.model.ScopeFunctionObject;
import com.user.role.tryer.repository.wrapper.RoleRepository;
import com.user.role.tryer.repository.wrapper.RoleScopeRepository;

//import com.user.role.tryer.repository.RoleRepository;
//import com.user.role.tryer.repository.RoleScopeRepository;

@RequestMapping("role")
@RestController
public class RoleController {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleScopeRepository roleScopeRepository;

//	@GetMapping
//	public List<Role> getAllRoles() {
//		
//		Session s = ((HibernateEntityManager) entityManager).getSession().getSessionFactory().openSession();
//		DetachedCriteria dc = DetachedCriteria.forClass(Role.class);
//		dc.setFetchMode("innerTable", FetchMode.SELECT);
//		Criteria c = dc.getExecutableCriteria(s);
//		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//		Role a = (Role)c.uniqueResult();
//		
////		Criteria c = ((Session)entityManager.getDelegate()).createCriteria(Role.class);
////		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//		return null;
//	}

	@PostMapping
	public boolean insertRole(@RequestBody RoleObject roleObject) {
		RoleWrapper role = new RoleWrapper();
		role.setName(roleObject.getRoleName());
		RoleWrapper roleEntity = this.roleRepository.save(role);
		
		Set<RoleScopeWrapper> roleScopeList = new HashSet<>();
		for (ScopeFunctionObject scopeFunctionObject : roleObject.getScopeFunctionList()) {
			String scopeId = scopeFunctionObject.getScopeId();
			for (String functionCode : scopeFunctionObject.getFunctionCodeList()) {
				roleScopeList.add(new RoleScopeWrapper(new ScopeWrapper(scopeId), new FunctionWrapper(functionCode), roleEntity));
			}
			// roleScopeList.add(new RoleScope(new Scope(scopeCode)));
		}
		
		this.roleScopeRepository.saveAll(roleScopeList);
		return true;
	}
}
