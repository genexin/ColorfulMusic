package cn.edu.xidian.cs.cm.mapper;

import cn.edu.xidian.cs.cm.entity.User;

/**
 *
 * @author MiZhou
 */
public interface UserMapper {

	public void addUser(User user);
	
	public void delUser(Integer id);

	public User getUserById(Integer id);

	public Integer getUserId(String username, String password);
	
	public User getUserByNameAndPass(String username, String password);
	
	public void updateUser(User user);
	
	public void collectSong(Integer userId, Integer songId);

}
