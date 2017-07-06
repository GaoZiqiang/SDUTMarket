package cn.edu.sdut.softlab.model;

import java.io.Serializable;
import java.util.Set;

import model.GeneratedValue;
import model.Id;
import model.SequenceGenerator;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERS_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_ID_GENERATOR")
	private Integer id;

	private String introduction;

	private String name;

	private String nickname;

	private String password;

	// bi-directional many-to-one association to BuiedItem
	@OneToMany(mappedBy = "user")
	private Set<BuiedItem> buiedItems;

	// bi-directional many-to-one association to PublishedItem
	@OneToMany(mappedBy = "user")
	private Set<PublishedItem> publishedItems;

	// bi-directional many-to-one association to SelledItem
	@OneToMany(mappedBy = "user")
	private Set<SelledItem> selledItems;

	public User() {
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Set<BuiedItem> getBuiedItems() {
		return this.buiedItems;
	}

	public void setBuiedItems(Set<BuiedItem> buiedItems) {
		this.buiedItems = buiedItems;
	}

	public BuiedItem addBuiedItem(BuiedItem buiedItem) {
		getBuiedItems().add(buiedItem);
		buiedItem.setUser(this);

		return buiedItem;
	}

	public BuiedItem removeBuiedItem(BuiedItem buiedItem) {
		getBuiedItems().remove(buiedItem);
		buiedItem.setUser(null);

		return buiedItem;
	}

	public Set<PublishedItem> getPublishedItems() {
		return this.publishedItems;
	}

	public void setPublishedItems(Set<PublishedItem> publishedItems) {
		this.publishedItems = publishedItems;
	}

	public PublishedItem addPublishedItem(PublishedItem publishedItem) {
		getPublishedItems().add(publishedItem);
		publishedItem.setUser(this);

		return publishedItem;
	}

	public PublishedItem removePublishedItem(PublishedItem publishedItem) {
		getPublishedItems().remove(publishedItem);
		publishedItem.setUser(null);

		return publishedItem;
	}

	public Set<SelledItem> getSelledItems() {
		return this.selledItems;
	}

	public void setSelledItems(Set<SelledItem> selledItems) {
		this.selledItems = selledItems;
	}

	public SelledItem addSelledItem(SelledItem selledItem) {
		getSelledItems().add(selledItem);
		selledItem.setUser(this);

		return selledItem;
	}

	public SelledItem removeSelledItem(SelledItem selledItem) {
		getSelledItems().remove(selledItem);
		selledItem.setUser(null);

		return selledItem;
	}

}