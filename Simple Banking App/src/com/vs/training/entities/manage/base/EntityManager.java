package com.vs.training.entities.manage.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.vs.training.db.connection.MySQLConnector;
import com.vs.training.entities.base.Entity;
import com.vs.training.entities.base.IEntityManager;

public abstract class EntityManager implements IEntityManager {

	private String dbName;
	
	public abstract String getTableName();
	public abstract List<String> getInsertColumns();

	public abstract PreparedStatement setInsertValues(Entity entity, PreparedStatement statement);

	public boolean insertEntity(Entity entity) {

		try {

			// fill column names ...
			List<String> columns = this.getInsertColumns();
			String fields = String.join(",", columns);
			// a,b,c,d ...

			List<String> phs = new ArrayList<String>();
			for (int i = 0; i < columns.size(); i++) {
				phs.add("?");
			}

			String placeHolders = String.join(",", phs);
			String sql = "INSERT INTO " + this.getTableName() + "(" + fields + ")" + "VALUES(" + placeHolders + ")";
			Connection connectionInstance = MySQLConnector.getConnectionInstance(dbName);

			PreparedStatement prepareStatement = connectionInstance.prepareStatement(sql);
			prepareStatement = this.setInsertValues(entity, prepareStatement);
			// prepareStatement.setValues...

			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

}
