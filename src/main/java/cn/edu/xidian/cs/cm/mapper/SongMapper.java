package cn.edu.xidian.cs.cm.mapper;

import cn.edu.xidian.cs.cm.entity.Song;
import java.util.List;

/**
 *
 * @author MiZhou
 */
public interface SongMapper {

	public void addSong(Song song);

	public void delSong(Integer id);

	public void updateSong(Song song);

	public Song getSong(Integer id);

	public List<Song> getSongs(int offset, int num);
}
