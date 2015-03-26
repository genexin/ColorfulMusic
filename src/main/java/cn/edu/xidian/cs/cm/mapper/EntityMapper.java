package cn.edu.xidian.cs.cm.mapper;

/**
 *
 * @author MiZhou
 * @param <Entity> 实体
 */
public interface EntityMapper<Entity> {

	public void addEntity(Entity entity);
	
	public void delEntity(Integer id);
	
	public void updateEntity(Entity entity);
	
	public void getEntity(Integer id);
}
