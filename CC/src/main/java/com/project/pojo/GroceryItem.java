package com.project.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name ="grocery_items")
public class GroceryItem {
 
	@Id
	@Column(name ="type_id", unique =true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int typeID;
	
	@Column(name ="type_name")
	private String typeName;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name= "item_id")
    private GroceryList item;

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public GroceryList getItem() {
		return item;
	}

	public void setItem(GroceryList item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "GroceryItem [typeID=" + typeID + ", typeName=" + typeName + ", item=" + item + "]";
	}

	public GroceryItem(int typeID, String typeName, GroceryList item) {
		super();
		this.typeID = typeID;
		this.typeName = typeName;
		this.item = item;
	}

	public GroceryItem() {
		super();
	}
	  
	

}
