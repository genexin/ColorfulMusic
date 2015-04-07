package cn.edu.xidian.cs.cm.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;

/**
 *
 * @author Mi Zhou
 */
@JsonInclude(Include.NON_NULL)
public class Singer implements Serializable {

	private static final long serialVersionUID = 2015_03L;

	private Integer id;
	private String name;
	private String comment;

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Singer{" + "id=" + id + ", name=" + name + ", comment=" + comment + '}';
	}

}
