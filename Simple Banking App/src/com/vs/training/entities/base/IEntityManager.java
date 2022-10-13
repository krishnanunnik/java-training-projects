package com.vs.training.entities.base;
public interface IEntityManager {
	
	boolean insert(Entity entity);
	
	boolean update(Entity entity);
	
	boolean delete(Entity entity);
	
	Entity get(Entity entity);
	
	boolean list();

}
