package cn.edu.sdut.softlab.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the buied_item database table.
 * 
 */
@Entity
@Table(name = "buied_item")
@NamedQuery(name = "BuiedItem.findAll", query = "SELECT b FROM BuiedItem b")
public class BuiedItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "buied_item_seq", sequenceName = "buied_item_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buied_item_seq")
	private Integer id;

	private String name;

	// bi-directional many-to-one association to Category
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id_fk")
	private Category category;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "buied_user_id_fk")
	private User user;

	public BuiedItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}