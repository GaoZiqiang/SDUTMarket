package cn.edu.sdut.softlab.model;

import java.io.Serializable;
import javax.persistence.*;

import model.GeneratedValue;
import model.Id;
import model.SequenceGenerator;

/**
 * The persistent class for the selled_item database table.
 * 
 */
@Entity
@Table(name = "selled_item")
@NamedQuery(name = "SelledItem.findAll", query = "SELECT s FROM SelledItem s")
public class SelledItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SELLED_ITEM_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SELLED_ITEM_ID_GENERATOR")
	private Integer id;

	private String name;

	@Column(name = "ogrigin_price")
	private double ogriginPrice;

	@Column(name = "sell_price")
	private double sellPrice;

	private String status;

	// bi-directional many-to-one association to Category
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id_fk")
	private Category category;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "selled_user_id_fk")
	private User user;

	public SelledItem() {
	}

	public Integer getId() {
		return this.id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getOgriginPrice() {
		return this.ogriginPrice;
	}

	public void setOgriginPrice(double ogriginPrice) {
		this.ogriginPrice = ogriginPrice;
	}

	public double getSellPrice() {
		return this.sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
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