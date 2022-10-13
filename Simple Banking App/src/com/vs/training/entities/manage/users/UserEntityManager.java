package com.vs.training.entities.manage.users;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.vs.training.entities.base.Entity;
import com.vs.training.entities.manage.base.EntityManager;
import com.vs.training.entities.users.User;

public class UserEntityManager extends EntityManager {

	@Override
	public boolean insert(Entity entity) {

		this.insertEntity(entity);
		return false;
	}

	@Override
	public boolean update(Entity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Entity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Entity get(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean list() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getInsertColumns() {
		return Arrays.asList("user_name", "first_name", "last_name", "created_time");
	}

	@Override
	public PreparedStatement setInsertValues(Entity entity, PreparedStatement statement) {

		try {
			User user = (User) entity;
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getFirstName());
			// ..
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statement;

	}

}
