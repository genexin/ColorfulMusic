package cn.edu.xidian.cs.cm.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;

/**
 *
 * @author MiZhou
 */
@JsonInclude(Include.NON_NULL)
public class Song implements Serializable {

	private static final long serialVersionUID = 2015_03L;

	private Integer id;

	private String title;
	private String year;
	private String comment;

	private int duration;
	private byte emotion;
	private String url;

	private Integer albumId;
	private Integer singerId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public byte getEmotion() {
		return emotion;
	}

	public void setEmotion(byte emotion) {
		this.emotion = emotion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public Integer getSingerId() {
		return singerId;
	}

	public void setSingerId(Integer singerId) {
		this.singerId = singerId;
	}

	@Override
	public String toString() {
		return "Song{" + "id=" + id + ", title=" + title + ", emotion=" + emotion + ", url=" + url + '}';
	}

}
