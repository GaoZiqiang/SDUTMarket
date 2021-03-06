package cn.edu.sdut.softlab.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

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
	@SequenceGenerator(name = "user_seq", sequenceName = "users_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private Integer id;

	private String introduction;

	private String name;

	private String nickname;

	private String password;

	// bi-directional many-to-one association to BuiedItem
	@OneToMany(mappedBy = "user")
	private Set<BuiedItem> buiedItems;

	// bi-directional many-to-one association to ItemComment
	@OneToMany(mappedBy = "user")
	private Set<ItemComment> itemComments;

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

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set<ItemComment> getItemComments() {
		return this.itemComments;
	}

	public void setItemComments(Set<ItemComment> itemComments) {
		this.itemComments = itemComments;
	}

	public ItemComment addItemComment(ItemComment itemComment) {
		getItemComments().add(itemComment);
		itemComment.setUser(this);

		return itemComment;
	}

	public ItemComment removeItemComment(ItemComment itemComment) {
		getItemComments().remove(itemComment);
		itemComment.setUser(null);

		return itemComment;
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