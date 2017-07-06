package cn.edu.sdut.softlab.model;

import java.io.Serializable;
import javax.persistence.*;

import model.GeneratedValue;
import model.Id;
import model.SequenceGenerator;

import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the published_item database table.
 * 
 */
@Entity
@Table(name = "published_item")
@NamedQuery(name = "PublishedItem.findAll", query = "SELECT p FROM PublishedItem p")
public class PublishedItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PUBLISHED_ITEM_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PUBLISHED_ITEM_ID_GENERATOR")
	private Integer id;

	private Boolean bargin;

	private String description;

	private String name;

	@Column(name = "origin_price")
	private double originPrice;

	private String picture;

	@Temporal(TemporalType.DATE)
	@Column(name = "publish_time")
	private Date publishTime;

	@Column(name = "sell_price")
	private double sellPrice;

	private String status;

	// bi-directional many-to-one association to Picture
	@OneToMany(mappedBy = "publishedItem")
	private Set<Picture> pictures;

	// bi-directional many-to-one association to Category
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id_fk")
	private Category category;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "published_user_id_fk")
	private User user;

	public PublishedItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getBargin() {
		return this.bargin;
	}

	public void setBargin(Boolean bargin) {
		this.bargin = bargin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getOriginPrice() {
		return this.originPrice;
	}

	public void setOriginPrice(double originPrice) {
		this.originPrice = originPrice;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public double getSellPrice() {
		return this.sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Set<Picture> getPictures() {
		return this.pictures;
	}

	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}

	public Picture addPicture(Picture picture) {
		getPictures().add(picture);
		picture.setPublishedItem(this);

		return picture;
	}

	public Picture removePicture(Picture picture) {
		getPictures().remove(picture);
		picture.setPublishedItem(null);

		return picture;
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