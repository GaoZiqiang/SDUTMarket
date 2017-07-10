package cn.edu.sdut.softlab.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the item_comment database table.
 * 
 */
@Entity
@Table(name = "item_comment")
@NamedQuery(name = "ItemComment.findAll", query = "SELECT i FROM ItemComment i")
public class ItemComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "item_comment_seq", sequenceName = "item_comment_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_comment_seq")
	private Integer id;

	private String comments;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comment_user_id_fk")
	private User user;

	public ItemComment() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}