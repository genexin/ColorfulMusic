package cn.edu.xidian.cs.cm.mapper;

import cn.edu.xidian.cs.cm.entity.Song;
import cn.edu.xidian.cs.cm.entity.User;
import java.util.List;

/**
 *
 * @author Mi Zhou
 */
public interface UserMapper {

	public void addUser(User user);

	public void delUserById(Integer id);

	public User getUserById(Integer id);

	public Integer getUserId(String username, String password);

	public void updateUser(User user);

	public void collectSong(Integer userId, Integer songId);

	public List<Song> getUserSongs(Integer userId);

}
