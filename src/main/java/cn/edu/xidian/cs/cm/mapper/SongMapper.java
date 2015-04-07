package cn.edu.xidian.cs.cm.mapper;

import cn.edu.xidian.cs.cm.entity.Song;
import java.util.List;

/**
 *
 * @author Mi Zhou
 */
public interface SongMapper {

	public void addSong(Song song);

	public void delSongById(Integer id);

	public void updateSong(Song song);

	public Song getSongById(Integer id);

	public List<Song> getSongs(int offset, int num);
}
