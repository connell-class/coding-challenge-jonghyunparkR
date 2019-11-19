package com.project.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name ="grocery_list")
public class GroceryList {
 
	@Id
	@Column(name ="item_id", unique =true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemId;
	
	@Column(name ="item_name")
	private String itemName;

	 @JsonIgnore
     @OneToMany(mappedBy = "item",cascade = CascadeType.ALL, fetch=FetchType.LAZY )
     private Set<GroceryItem> itemType = new HashSet<>();

	 
	 
	public GroceryList() {
		super();
	}

	public GroceryList(int itemId, String itemName) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "GroceryList [itemId=" + itemId + ", itemName=" + itemName + ", itemType=" + itemType + "]";
	}

	public Set<GroceryItem> getItemType() {
		return itemType;
	}

	public void setItemType(Set<GroceryItem> itemType) {
		this.itemType = itemType;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
     
}
