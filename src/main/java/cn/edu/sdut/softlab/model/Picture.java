package cn.edu.sdut.softlab.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the pictures database table.
 * 
 */
@Entity
@Table(name = "pictures")
@NamedQuery(name = "Picture.findAll", query = "SELECT p FROM Picture p")
public class Picture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String path;

	// bi-directional many-to-one association to PublishedItem
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "published_item_id_fk")
	private PublishedItem publishedItem;

	public Picture() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public PublishedItem getPublishedItem() {
		return this.publishedItem;
	}

	public void setPublishedItem(PublishedItem publishedItem) {
		this.publishedItem = publishedItem;
	}

}