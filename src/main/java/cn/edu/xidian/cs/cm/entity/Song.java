package cn.edu.xidian.cs.cm.entity;

import cn.edu.xidian.cs.cm.entity.serializer.SingerSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

/**
 *
 * @author Mi Zhou
 */
@JsonInclude(Include.NON_NULL)
public class Song implements Serializable {

	private static final long serialVersionUID = 2015_03L;

	private Integer id;

	private String name;
	private String title;
	private String year;
	private String comment;

	private int duration;
	private byte emotion;
	private String url;

	@JsonSerialize(using = SingerSerializer.class)
	private Singer singer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return "Song{" + "id=" + id + ", name=" + name + ", title=" + title + ", year=" + year + ", comment=" + comment + ", duration=" + duration + ", emotion=" + emotion + ", url=" + url + ", singer=" + singer + '}';
	}

}
