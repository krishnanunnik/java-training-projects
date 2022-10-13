package com.vs.training.entities.manage.users;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.vs.training.entities.base.Entity;
import com.vs.training.entities.users.Customer;

public class CustomerEntityManager extends UserEntityManager {

	@Override
	public boolean insert(Entity entity) {

		// ...

		if (entity instanceof Customer) {

			super.insert(entity);

			this.insertEntity(entity);

		}

		return false;
	}

	@Override
	public List<String> getInsertColumns() {

		return Arrays.asList("customer_id", "status", "customer_type");
	}

	@Override
	public PreparedStatement setInsertValues(Entity entity, PreparedStatement statement) {

		try {
			Customer customer = (Customer) entity;
			statement.setInt(1, customer.getUserId());
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return statement;
	}

	@Override
	public boolean update(Entity entity) {

		return false;
	}

	@Override
	public boolean delete(Entity entity) {

		return false;
	}

	@Override
	public Entity get(Entity entity) {

		return null;
	}

	@Override
	public boolean list() {

		return false;
	}

}
