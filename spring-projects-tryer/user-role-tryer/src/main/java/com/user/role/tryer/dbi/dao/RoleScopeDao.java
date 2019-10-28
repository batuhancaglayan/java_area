package com.user.role.tryer.dbi.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;
import org.skife.jdbi.v2.unstable.BindIn;

import com.user.role.tryer.dbi.dao.mapper.RoleScopeMapper;
import com.user.role.tryer.model.RoleScope;

@UseStringTemplate3StatementLocator
public interface RoleScopeDao {

	@RegisterMapper(RoleScopeMapper.class)
	@SqlQuery("SELECT * FROM role_scope WHERE role_id IN (<roleIdList>)")
	public abstract List<RoleScope> getRoleScope(@BindIn("roleIdList") List<Long> roleIdList);
}
