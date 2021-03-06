package cn.edu.sdut.softlab.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "category_seq", sequenceName = "cartegory_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
	private Integer id;

	private String name;

	// bi-directional many-to-one association to BuiedItem
	@OneToMany(mappedBy = "category")
	private Set<BuiedItem> buiedItems;

	// bi-directional many-to-one association to PublishedItem
	@OneToMany(mappedBy = "category")
	private Set<PublishedItem> publishedItems;

	// bi-directional many-to-one association to SelledItem
	@OneToMany(mappedBy = "category")
	private Set<SelledItem> selledItems;

	public Category() {
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

	public Set<BuiedItem> getBuiedItems() {
		return this.buiedItems;
	}

	public void setBuiedItems(Set<BuiedItem> buiedItems) {
		this.buiedItems = buiedItems;
	}

	public BuiedItem addBuiedItem(BuiedItem buiedItem) {
		getBuiedItems().add(buiedItem);
		buiedItem.setCategory(this);

		return buiedItem;
	}

	public BuiedItem removeBuiedItem(BuiedItem buiedItem) {
		getBuiedItems().remove(buiedItem);
		buiedItem.setCategory(null);

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
		publishedItem.setCategory(this);

		return publishedItem;
	}

	public PublishedItem removePublishedItem(PublishedItem publishedItem) {
		getPublishedItems().remove(publishedItem);
		publishedItem.setCategory(null);

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
		selledItem.setCategory(this);

		return selledItem;
	}

	public SelledItem removeSelledItem(SelledItem selledItem) {
		getSelledItems().remove(selledItem);
		selledItem.setCategory(null);

		return selledItem;
	}

}