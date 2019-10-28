package com.user.role.tryer.dbi.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.user.role.tryer.model.RoleScope;

public class RoleScopeMapper implements ResultSetMapper<RoleScope> {

	@Override
	public RoleScope map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException {
		RoleScope roleScope = new RoleScope();
		roleScope.setId(resultSet.getLong("id"));
		roleScope.setFunctionCode(resultSet.getString("function_code"));
		roleScope.setRoleId(resultSet.getLong("role_id"));
		roleScope.setScopeCode(resultSet.getString("scope_code"));
		return roleScope;
	}

}
