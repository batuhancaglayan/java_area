package com.user.role.tryer.dbi.dao;

import java.util.Iterator;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlBatch;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.BatchChunkSize;

import com.user.role.tryer.model.UserRole;

public interface UserRoleDao {

	@SqlQuery("SELECT role_id from user_role where user_id = :userId")
	public abstract List<Long> getUserRoleIdList(@Bind("userId") long userId);

    @BatchChunkSize(100)
    @SqlBatch("INSERT INTO user_role (id, role_id, user_id) VALUES (:rsl.id, :rsl.roleId, :rsl.userId)")
	public abstract void insertAll(@BindBean("rsl") Iterator<UserRole> roleScopeList);
}
