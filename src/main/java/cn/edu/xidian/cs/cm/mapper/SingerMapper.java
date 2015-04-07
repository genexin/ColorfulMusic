package cn.edu.xidian.cs.cm.mapper;

import cn.edu.xidian.cs.cm.entity.Singer;

/**
 *
 * @author Mi Zhou
 */
public interface SingerMapper {

	public void addSinger(Singer singer);

	public void delSingerById(Integer id);

	public void updateSinger(Singer singer);

	public Singer getSingerById(Integer id);
	
}
